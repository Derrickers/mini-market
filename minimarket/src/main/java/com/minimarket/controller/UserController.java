package com.minimarket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.service.UserService;
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
 * @create 2019-09-12 11:41
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
//    logger.info("22222222222\n"+js.getString("ID")+"\n"
//            +js.getString("Password")+"\n"
//            +js.getString("NickName")+"\n"
//    +js.getString("RealName")+"\n"
//    +js.getString("IDnum")+"\n"
//    +js.getString("Gender")+"\n"
//    +js.getString("Birthday")+"\n"
//    +js.getString("AddressUtil")+"\n"
//    +js.getString("Tel")+"\n"
//    +js.getString("Email")+"\n"
//    +js.getString("Credit")+"\n"
//    +js.getString("Photo")+"\n"
//    );
        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.userService.login(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public void selectUser(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        logger.info("1111111" + js);
        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.userService.selectUser(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.userService.register(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    @RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
    public void accountUpdate(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.userService.accountUpdate(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    @RequestMapping(value = "/passwordUpdate", method = RequestMethod.POST)
    public void passwordUpdate(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;
        //logger.info(js.toString());
        User user = JSON.parseObject(js.toString(), User.class);
        ReturnMsg returnMsg = this.userService.passwordUpdate(user);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }
}



