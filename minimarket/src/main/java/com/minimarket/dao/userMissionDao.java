package com.minimarket.dao;

import com.minimarket.model.User;
import com.minimarket.model.userMission;

/**
 * @author ronjod
 * @create 2019-09-27 15:45
 */
public interface userMissionDao {
    String selectReceiver(userMission userMission);
}
