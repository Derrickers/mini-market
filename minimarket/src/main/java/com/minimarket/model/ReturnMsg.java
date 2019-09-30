package com.minimarket.model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-09-17 14:54
 */
public class ReturnMsg {
    private boolean state;
    private String msg;
    private List<JSONObject> jsonMsg;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<JSONObject> getJsonMsg() {
        return jsonMsg;
    }

    public void setJsonMsg(List<JSONObject> jsonMsg) {
        this.jsonMsg = jsonMsg;
    }

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", jsonMsg=" + jsonMsg +
                '}';
    }

}
