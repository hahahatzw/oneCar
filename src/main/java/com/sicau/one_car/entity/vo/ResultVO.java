package com.sicau.one_car.entity.vo;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 15:30 2019/11/2
 **/
public class ResultVO {

    private int code;
    private String msg;
    private Object data;

    public ResultVO()
    {
        this.code=-1;
        this.msg=null;
        this.data=null;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
