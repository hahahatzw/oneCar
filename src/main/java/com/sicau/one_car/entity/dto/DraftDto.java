package com.sicau.one_car.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Description:帖子实体类
 * @author tzw
 * CreateTime 17:52 2019/11/11
 **/
public class DraftDto {

    private String id;

    private String content;

    private String imgSrc;

    private List<Integer> labelsId;

    private String userId;

    private int viewNum;

    private int likeNum;

    public DraftDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Integer> getLabelsId() {
        return labelsId;
    }

    public void setLabelsId(List<Integer> labelsId) {
        this.labelsId = labelsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
