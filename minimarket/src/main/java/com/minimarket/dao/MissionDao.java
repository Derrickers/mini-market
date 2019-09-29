package com.minimarket.dao;

import com.minimarket.model.Mission;

/**
 * @author ronjod
 * @create 2019-09-27 15:07
 */
public interface MissionDao {

    Mission selectMissionListAll();
    Mission selectMissionListUpload(Mission mission);
    Mission selectMissionListGet(Mission mission);
    Mission selectMissionInfo(Mission mission);

}
