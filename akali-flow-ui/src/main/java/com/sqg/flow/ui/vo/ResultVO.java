package com.sqg.flow.ui.vo;

import java.io.Serializable;

public class ResultVO implements Serializable {

    private int retCode;
    private String retMsg;
    private Object data;

    public ResultVO() {
    }

    public ResultVO(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public ResultVO(int retCode, String retMsg, Object data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public static ResultVO ok(){
        return new ResultVO();
    }

    public static ResultVO ok(Object data){
        return new ResultVO(0,"success",data);
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}


