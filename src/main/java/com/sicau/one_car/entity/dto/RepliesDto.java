package com.sicau.one_car.entity.dto;

import com.sicau.one_car.entity.po.Reply;

import java.util.Date;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 17:46 2019/12/3
 **/
public class RepliesDto extends ReplyDto {

    private String parentUsername;

    private String parentUserId;

    private Date replyTime;

    public String getParentUsername() {
        return parentUsername;
    }

    public void setParentUsername(String parentUsername) {
        this.parentUsername = parentUsername;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    @Override
    public Date getReplyTime() {
        return replyTime;
    }

    @Override
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
