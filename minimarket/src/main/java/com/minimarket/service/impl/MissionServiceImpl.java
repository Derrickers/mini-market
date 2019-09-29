package com.minimarket.service.impl;

import com.minimarket.controller.UserController;
import com.minimarket.dao.userMissionDao;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;
import com.minimarket.service.MissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ronjod
 * @create 2019-09-27 15:08
 */
@Service("missionService")
public class MissionServiceImpl implements MissionService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private userMissionDao userMissionDao;

    @Override
    public ReturnMsg selectReceiver(userMission userMission) {
            ReturnMsg returnMsg = new ReturnMsg();
            String temp = userMissionDao.selectReceiver(userMission);

            returnMsg.setMsg(temp);
//            if (temp != null) {
//                returnMsg.setState(true);
//                returnMsg.setMsg("0");
//                String cur = JSON.toJSONString(temp);
//                returnMsg.setJsonMsg(JSON.parseObject(cur));
//            } else {
//                returnMsg.setState(false);
//                returnMsg.setMsg("用户名不存在");
//            }
            return returnMsg;
    }
}