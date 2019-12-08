package com.sicau.one_car.service;

import com.sicau.one_car.entity.dto.UserDto;
import com.sicau.one_car.entity.po.User;
import com.sicau.one_car.entity.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 16:20 2019/11/2
 **/
public interface UserService {

    ResultVO login(String account, String password, HttpServletRequest request);

    ResultVO addUser(User user);

    ResultVO delUser(String id, HttpServletRequest request);

    ResultVO updateUser(User user);

    ResultVO getUserById(String id);
}
