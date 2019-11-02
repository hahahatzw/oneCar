package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.dao.UserDao;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.UserService;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 16:20 2019/11/2
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ResultVOUtil resultVOUtil;

    @Autowired
    private UserDao userDao;

    @Override
    public ResultVO login(String username, String password) {
       try {
           int result=userDao.selectByNameAndPassword(username,password);
           if(result==1)
               return resultVOUtil.success();
           else
               return resultVOUtil.fail();
       }catch (Exception e)
       {
           e.printStackTrace();
           return resultVOUtil.unknownError();
       }
    }
}
