package com.sicau.one_car.dao;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 16:25 2019/11/2
 **/
@Mapper
public interface UserDao {

    int selectByNameAndPassword(@Param("username") String username,@Param("password") String password);
}
