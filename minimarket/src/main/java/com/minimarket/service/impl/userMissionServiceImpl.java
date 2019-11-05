package com.minimarket.service.impl;

import com.minimarket.dao.MissionDao;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;
import com.minimarket.service.userMissionService;
import com.minimarket.utils.returnMsgUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ronjod
 * @create 2019-10-01 16:42
 */
@Service("userMissionService")
public class userMissionServiceImpl implements userMissionService {
    @Resource
    private com.minimarket.dao.userMissionDao userMissionDao;
    @Resource
    private com.minimarket.dao.MissionDao missionDao;
    @Resource
    private com.minimarket.dao.UserDao userDao;
    @Override
    public ReturnMsg acceptMission(userMission userMission) {
        int count = 0;
        try {
            count = userMissionDao.acceptMission(userMission);

        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("关系记录已存在", false);
        }
        if (count == 1) {
            Mission mission= new Mission();
            mission.setID(userMission.getID());
            synchronized (this) {//保证更新状态
                    List<Mission> temp = missionDao.selectMissionInfo(mission);
                if(temp.get(0).getAccNum()<temp.get(0).getQuota()) {
                    mission.setAccNum(temp.get(0).getAccNum() + 1);
                    missionDao.updateMission(mission);
                }
                else{
                    return returnMsgUtil.quickReturnMsg("reach the limitation", false);
                }
            }
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事，插入多条数据了", false);
        }
    }

    @Override
    public ReturnMsg abortMission(userMission userMission) {
        int count = 0;
        try {
            count = userMissionDao.abortMission(userMission);

        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("任务不存在", false);
        }

        if (count == 1) {
            return returnMsgUtil.quickReturnMsg("0", true);
        } else {
            return returnMsgUtil.quickReturnMsg("发生了啥，怎么回事，删多了？", false);
        }
    }

    //查询接收者id
    @Override
    public ReturnMsg selectReceiver(userMission userMission) {
        List<userMission> temp = userMissionDao.selectReceiver(userMission);
        if (temp != null) {
            return returnMsgUtil.quickReturnMsg(temp, String.valueOf(temp.size()), true);
        } else {
            return returnMsgUtil.quickReturnMsg("数据不存在", false);
        }
    }

//    更新用户任务表 对应状态 0 表示未完成 1 表示已完成
@Override
public ReturnMsg updateMission(userMission userMission) {

    String addressByPoster = userDao.getAddressByPoster(userMission);

    userMission.setPoster(addressByPoster);

    int count = userMissionDao.updateMission(userMission);
    if (count != 0) {
        return returnMsgUtil.quickReturnMsg("任务提交完成", true);
    } else {
        return returnMsgUtil.quickReturnMsg("任务提交失败", false);
    }
}
}
