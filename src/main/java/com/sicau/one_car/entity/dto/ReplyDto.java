package com.sicau.one_car.entity.dto;

import com.sicau.one_car.entity.po.Reply;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * @author tzw
 * CreateTime 12:07 2019/11/30
 **/
public class ReplyDto {

    private String replyId;

    private String draftId;

    private String parentId;

    private String replyContent;

    private String replyUserId;

    private Date replyTime;

    private String replyUsername;

    private List<RepliesDto> replies;

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }


    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername;
    }

    public List<RepliesDto> getReplies() {
        return replies;
    }

    public void setReplies(List<RepliesDto> replies) {
        this.replies = replies;
    }
}
