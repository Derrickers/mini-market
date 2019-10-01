package com.minimarket.service;

import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;

/**
 * @author ronjod
 * @create 2019-10-01 16:42
 */
public interface userMissionService {

    ReturnMsg acceptMission(userMission userMission);

    ReturnMsg abortMission(userMission userMission);

    ReturnMsg selectReceiver(userMission userMission);

}
