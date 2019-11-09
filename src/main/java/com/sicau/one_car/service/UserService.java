package com.sicau.one_car.service;

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

    ResultVO login(String username, String password, HttpServletRequest request);

    ResultVO addUser(String username, String password, String email, HttpServletRequest request);

    ResultVO delUser(String id, HttpServletRequest request);

    ResultVO updateUser(String id, String username, String password, String email, HttpServletRequest request);
}
