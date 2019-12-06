package com.sicau.one_car.entity.dto;

import com.sicau.one_car.entity.po.Message;

import java.util.Date;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:09 2019/12/4
 **/
public class MessageDto extends Message {

    private String  getUsername;

    private String sendUsername;

    public String getGetUsername() {
        return getUsername;
    }

    public void setGetUsername(String getUsername) {
        this.getUsername = getUsername;
    }

    public String getSendUsername() {
        return sendUsername;
    }

    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername;
    }
}
