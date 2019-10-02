package com.minimarket.service.impl;

import com.minimarket.controller.UserController;
import com.minimarket.dao.MissionDao;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.MissionService;
import com.minimarket.utils.returnMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-27 15:08
 */
@Service("missionService")
public class MissionServiceImpl implements MissionService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private MissionDao missionDao;
//    @Resource
//    private userMissionDao userMissionDao;

    //a)查询当前可以接取的全部任务
    @Override
    public ReturnMsg selectMissionListAll() {
        List<Mission> temp = missionDao.selectMissionListAll();
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("数据不存在", false);
        }
    }

    //b)	查询当前个人发布的全部任务
    @Override
    public ReturnMsg selectMissionListUpload(Mission mission) {
        List<Mission> temp = missionDao.selectMissionListUpload(mission);
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("数据不存在", false);
        }
    }

//c)	查询当前个人接取的全部任务

    @Override
    public ReturnMsg selectMissionListGet(User user) {
        List<Mission> temp = missionDao.selectMissionListGet(user);
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("数据不存在", false);
        }
    }

    //d)	查询某个任务具体信息
    @Override
    public ReturnMsg selectMissionInfo(Mission mission) {
        List<Mission> temp = missionDao.selectMissionInfo(mission);
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("数据不存在", false);
        }
    }

    @Override
    public ReturnMsg insertMission(Mission mission) {
        int count = 0;
        try {
            count = missionDao.insertMission(mission);

        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("任务已存在", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事，插入多条数据了？", false);
        }
    }

    @Override
    public ReturnMsg deleteMission(Mission mission) {
        int count = 0;
        try {
            count = missionDao.deleteMission(mission);

        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("任务不存在", false);
        }
        if (count == 1) {
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事，删多了？", false);
        }
    }

    @Override
    public ReturnMsg updateMission(Mission mission) {
        int count = 0;
        Object obj = null;
        synchronized (obj) {
            try {
                count = missionDao.updateMission(mission);

            } catch (Exception e) {
                return returnMsgUtil.quickReturnMsg("任务不存在", false);
            }
            if (count == 1) {
                return returnMsgUtil.quickReturnMsg("0", true);
            } else {
                return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事，更新了多条数据？完蛋", false);
            }
        }
    }
}