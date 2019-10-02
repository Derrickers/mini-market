package com.minimarket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;
import com.minimarket.service.userMissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ronjod
 * @create 2019-10-01 20:28
 */
@Controller
@RequestMapping("/userMission")
public class userMissionController {
    @Resource
    private userMissionService userMissionService;

    //这个是用来测试获取接收者id的控制器
    @RequestMapping(value = "/selectReceiver", method = RequestMethod.POST)
    public void selectReceiver(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        userMission userMission = JSON.parseObject(js.toString(), userMission.class);
        ReturnMsg returnMsg = this.userMissionService.selectReceiver(userMission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //插入关系表信息
    @RequestMapping(value = "/acceptMission", method = RequestMethod.POST)
    public void acceptMission(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        userMission userMission = JSON.parseObject(js.toString(), userMission.class);
        ReturnMsg returnMsg = this.userMissionService.acceptMission(userMission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //删除关系表信息
    @RequestMapping(value = "/abortMission", method = RequestMethod.POST)
    public void abortMission(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        userMission userMission = JSON.parseObject(js.toString(), userMission.class);
        ReturnMsg returnMsg = this.userMissionService.abortMission(userMission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }
}
