package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.dao.UserDao;
import com.sicau.one_car.entity.dto.User;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.UserService;
import com.sicau.one_car.util.IDUtil;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public ResultVO login(String username, String password, HttpServletRequest request) {
       try {
           User user=userDao.selectByNameAndPassword(username,password);
           HttpSession session=request.getSession();
           session.setAttribute(Const.RoleEnum.USER.getRole(),user);
           if(user!=null)
               return resultVOUtil.success();
           else
               return resultVOUtil.fail();
       }catch (Exception e)
       {
           e.printStackTrace();
           return resultVOUtil.unknownError();
       }
    }

    @Override
    public ResultVO addUser(String username, String password, String email, HttpServletRequest request) {
        try {
            boolean addTest = userDao.addUser(IDUtil.getUUID(),username,password,email);
            if(addTest)
                return resultVOUtil.success();
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    public ResultVO delUser(String id, HttpServletRequest request) {
        try {
            boolean delTest = userDao.delUser(id);
            if(delTest)
                return resultVOUtil.success();
            else
                return resultVOUtil.fail();
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }

    @Override
    public ResultVO updateUser(String id, String username, String password, String email, HttpServletRequest request) {
        try {
            boolean updataTest = userDao.updateUser(id,username,password,email);
            if(updataTest)
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
