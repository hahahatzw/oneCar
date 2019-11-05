package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.User;
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

    User selectByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
