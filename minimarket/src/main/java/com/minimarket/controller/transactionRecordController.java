package com.minimarket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.transactionRecord;
import com.minimarket.service.transactionRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author ronjod
 * @create 2019-10-07 10:36
 */
@Controller
@RequestMapping("/transactionRecord")
public class transactionRecordController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private transactionRecordService transactionRecordService;

    //查交易信息
    @RequestMapping(value = "/getTransactionRecord", method = RequestMethod.POST)
    public void getTransactionRecord(@RequestBody String address, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        ReturnMsg returnMsg = this.transactionRecordService.getTransactionRecord(address);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //插入交易信息
    @RequestMapping(value = "/insertTransactionRecord", method = RequestMethod.POST)
    public void insertTransactionRecord(@RequestBody JSONObject jsonbody, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JSONObject js = jsonbody;

        transactionRecord transactionRecord = JSON.parseObject(js.toString(), transactionRecord.class);
        ReturnMsg returnMsg = null;
        try {
            returnMsg = this.transactionRecordService.insertTransactionRecord(transactionRecord);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(returnMsg));
        response.getWriter().close();
    }

    //查余额
//查
    @RequestMapping(value = "/getBalance", method = RequestMethod.POST)
    public void getBalance(@RequestBody String address, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        String money = null;
        try {
            money = this.transactionRecordService.getBalance(address);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(money));
        response.getWriter().close();
    }
}
