package com.sicau.one_car.entity.dto;

import com.sicau.one_car.entity.po.Label;
import com.sicau.one_car.entity.po.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Description:帖子实体类
 * @author tzw
 * CreateTime 17:52 2019/11/11
 **/
public class DraftDto {

    private String draftId;

    private String content;

    private String imgSrc;

    private List<Label> labels;

    private String userId;

    private String username;

    private int viewNum;

    private int likeNum;

    private Date createTime;

    private List<ReplyDto> replyList;

    public DraftDto() {

    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ReplyDto> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<ReplyDto> replyList) {
        this.replyList = replyList;
    }
}
