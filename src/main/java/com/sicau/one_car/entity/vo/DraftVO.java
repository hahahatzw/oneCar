package com.sicau.one_car.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Description:视图层帖子实体类,用于获取实体的增，不作为返回于视图层对象
 * @author tzw
 * CreateTime 21:42 2019/11/13
 **/
@ApiModel
public class DraftVO {

    @ApiModelProperty(value = "主键id",hidden = true)
    private String id;

    @ApiModelProperty(value = "帖子内容" ,example = "这是一条帖子")
    private String content;

    @ApiModelProperty(value = "文件路径",example = "D:/picture/one.jpg")
    private String imgSrc;

    @ApiModelProperty(value = "发表的用户id",example = "sahsa887sasd90as")
    private String userId;

    @ApiModelProperty(value = "观看数",example = "12")
    private int viewNum;

    @ApiModelProperty(value = "喜欢数",example= "3")
    private int likeNum;

    public DraftVO() {
        this.viewNum=0;
        this.likeNum=0;
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
