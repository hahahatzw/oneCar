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

    boolean addUser(@Param("id") String id,@Param("username") String username, @Param("password") String password,@Param("email") String email);

    boolean delUser(@Param("id") String id);

    boolean updateUser(@Param("id") String id,@Param("username") String username, @Param("password") String password,@Param("email") String email);
}
