package com.sicau.one_car.common;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 15:30 2019/11/2
 **/
public class Const {

    public final static String version="/v1";
    public final static String unpublic="/unpub";
    public final static String pub="/pub";

    /**
     * 返回响应状态枚举
     */
    public enum ResultEnum{

        SUCCESS(1,"操作成功"),
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

    /**
     * 角色枚举
     */
    public enum RoleEnum{
        USER("user",0),
        ADMIN("admin",1);

        private int code;
        private String role;

        RoleEnum(String role,int code)
        {
            this.role=role;
            this.code=code;
        }

        public int getCode() {
            return code;
        }

        public String getRole() {
            return role;
        }
    }

    /**
     * 图像识别类型枚举
     */
    public enum ImageRecognitionType{
        Vehicle_Detection(0,"车型检测"),
        Vehicle_Damage(1,"车辆损伤检测"),
        Vehicle_Attributes(2,"车辆属性检测"),
        Vehicle_Segmentation(3,"车辆分割"),
        Vehicle_Detect(4,"车辆检测")
        ;

        private int code;
        private String msg;

        ImageRecognitionType(int code,String msg)
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

    /**
     * 文件相关枚举
     */

    public enum FileEnum{
        File_Size(1024*1024*5,"文件大小限制"),
        File_Type_Error(1,"文件格式错误");

        private int code;
        private String msg;

        FileEnum(int code,String msg)
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

    /**
     * 消息枚举
     */

    public enum MessageEnum{
        Like_Draft(1,"有人给你的帖子点了一个赞"),
        Reply_Draft(2,"有人回复了你的帖子"),
        Reply_Reply(3,"有人回复了你的评论");


        private String content;
        private int code;

        MessageEnum(int code,String content){
            this.code=code;
            this.content=content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
