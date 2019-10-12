package com.minimarket.service.impl;

import com.minimarket.controller.UserController;
import com.minimarket.dao.UserDao;
import com.minimarket.model.Ethereum;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.UserService;
import com.minimarket.utils.AddressUtil;
import com.minimarket.utils.returnMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author ronjod
 * @create 2019-09-12 11:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserDao userDao;
    @Resource
    private com.minimarket.service.transactionRecordService transactionRecordService;

    //密码修改
    @Override
    public ReturnMsg passwordUpdate(User user) {
        int count = 0;

        try {
            count = userDao.passwordUpdate(user);
        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("用户名不存在,密码修改失败", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("出大事了密码咋修改了多个/用户名不存在,密码修改失败", false);
        }
    }

    //信息修改
    @Override
    public ReturnMsg accountUpdate(User user) {
        List<User> temp = userDao.selectUser(user);

        Object obj = null;
        int count = 0;
        synchronized (obj) {
            try {
                count = userDao.accountUpdate(user);

            } catch (Exception e) {
                return returnMsgUtil.quickReturnMsg("用户名不存在,信息修改失败", false);
            }
            if (count == 1) {
                return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
            } else {
                return returnMsgUtil.quickReturnMsg("出大事了信息咋修改了多个/用户名不存在,修改失败", false);
            }
        }
    }

    //登录
    @Override
    public ReturnMsg login(User user) {
        if (userDao.login(user) != null) {
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("用户名/密码错误", false);
        }
    }

    //注册
    @Override
    public ReturnMsg register(User user) {
        int count = 0;
        AddressUtil addressUtil =new AddressUtil();
        List<String> list = new ArrayList<>(2);
        Ethereum ethereum = null;
        try {
            if (userDao.checkUser(user) == null) {
                list = transactionRecordService.createAccount(user.getPassword());
                ethereum = new Ethereum(list.get(0),"sorry i am noob");
                user.setAddress(list.get(0));
                count = userDao.register(user);
            } else {
                return returnMsgUtil.quickReturnMsg("用户名已存在", false);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Ethereum> temp = new ArrayList<>();
        temp.add(ethereum);//返回钱包地址和token

        try {
            transactionRecordService.freeHelp(user.getAddress());
            transactionRecordService.transferEth(user.getAddress());//送你以太币，没钱了啊洒家
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg(temp, "0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事", false);
        }

    }

    //查询
    @Override
    public ReturnMsg selectUser(User user) {
        List<User> temp = userDao.selectUser(user);
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("用户名不存在", false);
        }
    }
}
