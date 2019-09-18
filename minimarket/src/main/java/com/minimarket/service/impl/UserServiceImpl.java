package com.minimarket.service.impl;

import com.alibaba.fastjson.JSON;
import com.minimarket.controller.UserController;
import com.minimarket.dao.UserDao;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        ReturnMsg returnMsg = new ReturnMsg();
        int count = 0;
        try {
            count = userDao.passwordUpdate(user);

        } catch (Exception e) {
            returnMsg.setState(false);
            returnMsg.setMsg("用户名不存在,密码修改失败");
        }
        if (count == 1) {
            returnMsg.setState(true);
            returnMsg.setMsg("0");
        }
        return returnMsg;
    }

    //信息修改
    @Override
    public ReturnMsg accountUpdate(User user) {
        ReturnMsg returnMsg = new ReturnMsg();
        User temp = userDao.selectUser(user);

        int count = 0;
        try {
            count = userDao.accountUpdate(user);

        } catch (Exception e) {
            returnMsg.setState(false);
            returnMsg.setMsg("用户名不存在,信息修改失败");
        }
        if (count == 1) {
            returnMsg.setState(true);
            returnMsg.setMsg("0");
            String cur = JSON.toJSONString(temp);
            //转换为json格式
            returnMsg.setJsonMsg(JSON.parseObject(cur));
        }
        return returnMsg;
    }

    //登录
    @Override
    public ReturnMsg login(User user) {
        ReturnMsg returnMsg = new ReturnMsg();
        if (userDao.login(user) != null) {
            returnMsg.setState(true);
            returnMsg.setMsg("0");
        } else {
            returnMsg.setState(false);
            returnMsg.setMsg("用户名/密码错误");
        }
        return returnMsg;
    }

    //注册
    @Override
    public ReturnMsg register(User user) {
        ReturnMsg returnMsg = new ReturnMsg();
        int count = 0;
        try {
            count = userDao.register(user);
        } catch (Exception e) {
            returnMsg.setState(false);
            returnMsg.setMsg("用户名已存在");
        }
        logger.info("54545445" + count);
        if (count == 1) {
            returnMsg.setState(true);
            returnMsg.setMsg("0");
        }
        return returnMsg;
    }

    //查询
    @Override
    public ReturnMsg selectUser(User user) {
        ReturnMsg returnMsg = new ReturnMsg();
        User temp = userDao.selectUser(user);

        if (temp != null) {
            returnMsg.setState(true);
            returnMsg.setMsg("0");
            String cur = JSON.toJSONString(temp);
            returnMsg.setJsonMsg(JSON.parseObject(cur));
        } else {
            returnMsg.setState(false);
            returnMsg.setMsg("用户名不存在");
        }
        return returnMsg;
    }
}
