package com.minimarket.dao;

import com.minimarket.model.User;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-12 11:42
 */
public interface UserDao {

    List<User> selectUser(User user);

    List<User> login(User user);

    int register(User user);

    int accountUpdate(User user);

    int passwordUpdate(User user);//可能要废弃

    String checkUser(User user);
}
