package com.sicau.one_car.service;

import com.sicau.one_car.entity.vo.ResultVO;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 16:20 2019/11/2
 **/
public interface UserService {

    ResultVO login(String username, String password);
}
