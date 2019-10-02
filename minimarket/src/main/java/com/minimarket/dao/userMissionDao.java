package com.minimarket.dao;

import com.minimarket.model.userMission;

/**
 * @author ronjod
 * @create 2019-09-27 15:45
 */
public interface userMissionDao {
    //目前没写list操作
    String selectReceiver(userMission userMission);

    int acceptMission(userMission userMission);

    int abortMission(userMission userMission);
}
