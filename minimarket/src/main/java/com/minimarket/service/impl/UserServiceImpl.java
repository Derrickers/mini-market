package com.minimarket.service.impl;

import com.minimarket.controller.UserController;
import com.minimarket.dao.UserDao;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.UserService;
import com.minimarket.utils.returnMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-12 11:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserDao userDao;

    //密码修改
    @Override
    public ReturnMsg passwordUpdate(User user) {
        int count = 0;
        try {
            count = userDao.passwordUpdate(user);
        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg( "用户名不存在,密码修改失败", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg( "0", true);
        }
        else{
            return returnMsgUtil.quickReturnMsg( "出大事了密码咋修改了多个/用户名不存在,密码修改失败", false);
        }
    }

    //信息修改
    @Override
    public ReturnMsg accountUpdate(User user) {
        List<User> temp = userDao.selectUser(user);

        int count = 0;
        try {
            count = userDao.accountUpdate(user);

        } catch (Exception e) {
             return returnMsgUtil.quickReturnMsg( "用户名不存在,信息修改失败", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else{
            return returnMsgUtil.quickReturnMsg( "出大事了信息咋修改了多个/用户名不存在,修改失败", false);
        }

    }

    //登录
    @Override
    public ReturnMsg login(User user) {
        if (userDao.login(user) != null) {
            return returnMsgUtil.quickReturnMsg( "0", true);
        } else {
                return returnMsgUtil.quickReturnMsg( "用户名/密码错误", false);
        }
    }

    //注册
    @Override
    public ReturnMsg register(User user) {
        int count = 0;
        try {
            count = userDao.register(user);
        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("用户名已存在", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg("0", true);
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
