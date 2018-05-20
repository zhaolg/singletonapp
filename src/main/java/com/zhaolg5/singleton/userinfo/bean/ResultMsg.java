package com.zhaolg5.singleton.userinfo.bean;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by zhaolg on 2018/5/18
 *
 * @return
 * @throws Exception
 */
public class ResultMsg {

    private String msgCode;

    private String msgValue;

    private String msgDesc;

    private JSONObject extValue;

    public JSONObject getExtValue() {
        return extValue;
    }

    public void setExtValue(JSONObject extValue) {
        this.extValue = extValue;
    }

    public ResultMsg() {
    }

    public ResultMsg(String msgCode, String msgValue) {
        this.msgCode = msgCode;
        this.msgValue = msgValue;
    }

    public ResultMsg(String msgCode, String msgValue, String msgDesc) {
        this.msgCode = msgCode;
        this.msgValue = msgValue;
        this.msgDesc = msgDesc;
    }

    public String getMsgValue() {
        return msgValue;
    }

    public void setMsgValue(String msgValue) {
        this.msgValue = msgValue;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }
}
