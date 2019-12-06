package com.sicau.one_car.service.serviceImpl;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.dao.UserDao;
import com.sicau.one_car.entity.dto.UserDto;
import com.sicau.one_car.entity.po.User;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.UserService;
import com.sicau.one_car.util.IDUtil;
import com.sicau.one_car.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
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
    public ResultVO login(String account, String password, HttpServletRequest request) {
       try {
           User user=userDao.selectByNameAndPassword(account,password);
           HttpSession session=request.getSession();
           session.setAttribute(Const.RoleEnum.USER.getRole(),user);
           user.setPassword("  ");
           if(user!=null)
               return resultVOUtil.success("登陆成功",user);
           else
               return resultVOUtil.fail();
       }catch (Exception e)
       {
           e.printStackTrace();
           return resultVOUtil.unknownError();
       }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO addUser(User user) {
      try {
          User val=userDao.selectByEmail(user.getEmail());
          if(val==null)
          {
              int result=userDao.insertUser(user);
              user.setPassword("  ");
              if(result==1)
                  return resultVOUtil.success("注册成功",user);
              else
                  return resultVOUtil.fail("注册失败,请重试");
          }else
              return resultVOUtil.fail("该用户已注册过");
      }catch (Exception e)
      {
          e.printStackTrace();
          TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
          return resultVOUtil.unknownError();
      }
    }



    @Override
    public ResultVO delUser(String id, HttpServletRequest request) {
        try {
            int delTest = userDao.delUser(id);
            if(delTest==1)
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
            int updataTest = userDao.updateUser(id,username,password,email);
            if(updataTest==1)
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
    public ResultVO getUserById(String id) {
        try{
            User user=userDao.selectById(id);
            if(user!=null)
                return resultVOUtil.success(user);
            else
                return resultVOUtil.fail("未查找到该用户");
        }catch (Exception e)
        {
            e.printStackTrace();
            return resultVOUtil.unknownError();
        }
    }
}
