package com.sicau.one_car.entity.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Description:
 * @author tzw
 * CreateTime 12:00 2019/11/30
 **/
@ApiModel
public class ReplyVO {

    @ApiModelProperty(value = "回复帖子的id",example = "14cdd9d22df6469e982b59c4beefefc4")
    private String draftId;

    @ApiModelProperty(value = "父回复的id",example = "0000")
    private String parentId;

    @ApiModelProperty(value = "回复内容",example = "这是一条回复")
    private String replyContent;

    @ApiModelProperty(value = "评论者id",example = "72b2a78eef8948c89abe644c7b94a8fb")
    private String replyUserId;

    @ApiModelProperty(value = "回复时间",example = "2019-03-12 11:59",hidden = true)
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
