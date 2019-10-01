package com.minimarket.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.minimarket.model.ReturnMsg;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-30 10:28
 */
public class returnMsgUtil {

    public static ReturnMsg quickReturnMsg(List<?> temp, String msg, boolean flag) {
        ReturnMsg returnMsg = new ReturnMsg();
        returnMsg.setState(flag);
        returnMsg.setMsg(msg);
        String cur = JSON.toJSONString(temp);
        List<JSONObject> list = JSONObject.parseArray(cur, JSONObject.class);
        //转换为json格式
        returnMsg.setJsonMsg(list);
        return returnMsg;
    }

    public static ReturnMsg quickReturnMsg(String msg, boolean flag) {
        ReturnMsg returnMsg = new ReturnMsg();
        returnMsg.setState(flag);
        returnMsg.setMsg(msg);
        //转换为json格式
        return returnMsg;
    }
}
