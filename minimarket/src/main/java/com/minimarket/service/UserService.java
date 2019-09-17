package com.minimarket.service;

import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;

/**
 * @author ronjod
 * @create 2019-09-12 11:43
 */
public interface UserService {

public ReturnMsg selectUser(User user);
public ReturnMsg login(User user);
    public ReturnMsg register(User user);
    public ReturnMsg accountUpdate(User user);
    ReturnMsg passwordUpdate(User user);
}
