package com.minimarket.dao;

import com.minimarket.model.Mission;
import com.minimarket.model.User;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-27 15:07
 */
public interface MissionDao {

    List<Mission> selectMissionListAll();

    List<Mission> selectMissionListUpload(Mission mission);

    List<Mission> selectMissionListGet(User user);

    List<Mission> selectMissionInfo(Mission mission);

    int insertMission(Mission mission);

    int deleteMission(Mission mission);

    int updateMission(Mission mission);

}
