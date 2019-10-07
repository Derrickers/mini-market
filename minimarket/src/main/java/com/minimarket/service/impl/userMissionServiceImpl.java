package com.minimarket.service.impl;

import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;
import com.minimarket.service.userMissionService;
import com.minimarket.utils.returnMsgUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ronjod
 * @create 2019-10-01 16:42
 */
@Service("userMissionService")
public class userMissionServiceImpl implements userMissionService {
    @Resource
    private com.minimarket.dao.userMissionDao userMissionDao;

    @Override
    public ReturnMsg acceptMission(userMission userMission) {
        int count = 0;
        try {
            count = userMissionDao.acceptMission(userMission);

        } catch (Exception e) {
            return returnMsgUtil.quickReturnMsg("关系记录已存在", false);
        }
        if (count == 1) {
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

        ReturnMsg returnMsg = new ReturnMsg();
        String temp = userMissionDao.selectReceiver(userMission);
        returnMsg.setMsg(temp);
        return returnMsg;
    }
}
