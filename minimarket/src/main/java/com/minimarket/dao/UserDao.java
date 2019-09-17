package com.minimarket.dao;

import com.minimarket.model.User;

/**
 * @author ronjod
 * @create 2019-09-12 11:42
 */
public interface UserDao {

    User selectUser(User user);
    User login(User user);
    int register(User user);
    int accountUpdate(User user);
    int passwordUpdate(User user);
}
