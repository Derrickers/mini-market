package com.minimarket.service;

import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;

/**
 * @author ronjod
 * @create 2019-09-27 15:07
 */
public interface MissionService {

    ReturnMsg selectMissionListAll();

    ReturnMsg selectMissionListUpload(Mission mission);

    ReturnMsg selectMissionListGet(User user);

    ReturnMsg selectMissionInfo(Mission mission);

    ReturnMsg insertMission(Mission mission);

    ReturnMsg deleteMission(Mission mission);

    ReturnMsg updateMission(Mission mission);

}
