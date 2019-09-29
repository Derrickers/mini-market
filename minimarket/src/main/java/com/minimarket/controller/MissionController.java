package com.minimarket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.userMission;
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
    private MissionService missonService ;

    @RequestMapping(value = "/selectMissionListAll", method = RequestMethod.POST)
    public void selectMissionListAll(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        logger.info("1111111"+js);
        userMission userMission = JSON.parseObject(js.toString(), userMission.class);
        ReturnMsg returnMsg = this.missonService.selectReceiver(userMission);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

}
