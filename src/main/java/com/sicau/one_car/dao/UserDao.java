package com.sicau.one_car.dao;

import com.sicau.one_car.entity.dto.UserDto;
import com.sicau.one_car.entity.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

/**
 * Description:
 * @author tzw
 * CreateTime 16:25 2019/11/2
 **/
public interface UserDao {

    User selectByNameAndPassword(@Param("account") String account, @Param("password") String password);

    int addUser(@Param("id") String id,@Param("username") String username, @Param("password") String password,@Param("email") String email);

    int delUser(@Param("id") String id);

    int updateUser(User user);

    UserDto findByUsername(@Param("username") String username);

    @Select("select * from user_tb where email=#{email}")
    User selectByEmail(@Param("email") String email);

    int insertUser(User user);

    User selectById(@Param("id") String id);
}
