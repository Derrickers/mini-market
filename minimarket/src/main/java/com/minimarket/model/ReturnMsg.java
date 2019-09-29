package com.minimarket.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ronjod
 * @create 2019-09-17 14:54
 */
public class ReturnMsg {
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

    public JSONObject getJsonMsg() {
        return jsonMsg;
    }

    public void setJsonMsg(JSONObject jsonMsg) {
        this.jsonMsg = jsonMsg;
    }

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "state=" + state +
                ", num=" + msg +
                ", jsonMsg='" + jsonMsg + '\'' +
                '}';
    }

    private boolean state;
    private String msg;
    private JSONObject jsonMsg;

}
