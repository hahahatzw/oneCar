package com.sicau.one_car.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 9:39 2019/11/16
 **/
public class CopyProperties {
    /**
     * 利用反射将源数据和目标类中属性相同的属性赋值，并实例化目标类对象
     *
     */
    public static <T> T copy(Object source, Class<T> targetClass) {

        Class sourceClass = source.getClass();//得到对象的Class



        Field[] sourceFields = sourceClass.getDeclaredFields();//得到Class对象的所有属性
        Field[] targetFields = targetClass.getDeclaredFields();//得到Class对象的所有属性

        try{
            T target = targetClass.newInstance();
            for(Field sourceField : sourceFields){
                String name = sourceField.getName();//属性名
                Class type = sourceField.getType();//属性类型

                String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);

                Method getMethod = sourceClass.getMethod("get" + methodName);//得到属性对应get方法

                Object value = getMethod.invoke(source);//执行源对象的get方法得到属性值

                for(Field targetField : targetFields){
                    String targetName = targetField.getName();//目标对象的属性名
                    Class targetType = targetField.getType();

                    if(targetName.equals(name) && targetType.equals(type)){
                        Method setMethod = targetClass.getMethod("set" + methodName, type);//属性对应的set方法

                        setMethod.invoke(target, value);//执行目标对象的set方法
                    }
                }
            }
            return target;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
