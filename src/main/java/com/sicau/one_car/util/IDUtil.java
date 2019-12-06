package com.sicau.one_car.util;

/**
 * Description:用于生成id
 * @author yj
 * CreateTime 2019/11/06
 **/

public class IDUtil {

    //邮箱验证码长度，默认5
    public static final int EMAIL_CODE_LEN=5;

    public static String getUUIDByLen(int len){
        String idStr = String.valueOf(java.util.UUID.randomUUID());
        idStr = idStr.replace('-',' ');
        if(len < idStr.length()){
            idStr = idStr.substring(0,len);
        }
        return idStr;
    }

    public static String getUUID(){
        String UUID = String.valueOf(java.util.UUID.randomUUID());
        return UUID.replace("-","");
    }

    public static String getEmailCode()
    {
        return getUUIDByLen(EMAIL_CODE_LEN);
    }
}
