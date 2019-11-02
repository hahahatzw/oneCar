package com.sicau.one_car.common;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 15:30 2019/11/2
 **/
public class Const {

    public enum ResultEnum{

        SUCESS(1,"操作成功"),
        Fail(0,"操作失败"),
        UNKNOWN_ERROR(-1,"未知错误");

        private int code;
        private String msg;
        ResultEnum(int code,String msg)
        {
            this.code=code;
            this.msg=msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
