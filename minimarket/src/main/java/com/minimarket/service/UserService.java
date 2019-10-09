package com.minimarket.service;

import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;

/**
 * @author ronjod
 * @create 2019-09-12 11:43
 */
public interface UserService {

    ReturnMsg selectUser(User user);

    ReturnMsg login(User user);

    ReturnMsg register(User user);

    ReturnMsg accountUpdate(User user);

    ReturnMsg passwordUpdate(User user);

}
