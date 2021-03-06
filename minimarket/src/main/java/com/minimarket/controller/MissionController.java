package com.minimarket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.MissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ronjod
 * @create 2019-09-27 15:06
 */
@Controller
@RequestMapping("/mission")
public class MissionController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private MissionService missonService;

    //这个是用来测试获取接收者id的控制器
//    @RequestMapping(value = "/selectMissionListAll", method = RequestMethod.POST)
//    public void selectMissionListAll(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
//        response.setCharacterEncoding("UTF-8");
//        JSONObject js = jsonbody;
//        logger.info("1111111"+js);
//        userMission userMission = JSON.parseObject(js.toString(), userMission.class);
//        ReturnMsg returnMsg = this.missonService.selectReceiver(userMission);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(returnMsg));
//        response.getWriter().close();
//    }
    //a)	查询当前可以接取的全部任务
    @RequestMapping(value = "/selectMissionListAll", method = RequestMethod.POST)
    public void selectMissionListAll(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;

        ReturnMsg returnMsg = this.missonService.selectMissionListAll();
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    // b)	查询当前个人发布的全部任务
    @RequestMapping(value = "/selectMissionListUpload", method = RequestMethod.POST)
    public void selectMissionListUpload(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;

        Mission mission = JSON.parseObject(js.toString(), Mission.class);
        ReturnMsg returnMsg = this.missonService.selectMissionListUpload(mission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //c)	查询当前个人接取的全部任务
    @RequestMapping(value = "/selectMissionListGet", method = RequestMethod.POST)
    public void selectMissionListGet(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;

        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.missonService.selectMissionListGet(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //d)	查询某个任务具体信息
    @RequestMapping(value = "/selectMissionInfo", method = RequestMethod.POST)
    public void selectMissionInfo(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;

        Mission mission = JSON.parseObject(js.toString(), Mission.class);
        ReturnMsg returnMsg = this.missonService.selectMissionInfo(mission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }
}
