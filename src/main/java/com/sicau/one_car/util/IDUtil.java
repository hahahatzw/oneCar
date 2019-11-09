package com.sicau.one_car.util;

/**
 * Description:用于生成id
 * @author yj
 * CreateTime 2019/11/06
 **/

public class IDUtil {

    public static String getUUID(){
        String UUID = String.valueOf(java.util.UUID.randomUUID());
        return UUID.replace("-","");
    }
}
