package com.sicau.one_car.controller;

import com.sicau.one_car.common.Const;
import com.sicau.one_car.entity.dto.UserDto;
import com.sicau.one_car.entity.po.User;
import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.entity.vo.UserVO;
import com.sicau.one_car.service.UserService;
import com.sicau.one_car.util.CopyProperties;
import com.sicau.one_car.util.IDUtil;
import com.sicau.one_car.util.MailUtil;
import com.sicau.one_car.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description:用户信息管理controller层
 * @author tzw
 * CreateTime 20:41 2019/10/25
 **/


@Api(value = "用户信息" ,description = "用于用户信息的增删查改")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登陆",notes = " ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "账户",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType = "string",paramType = "query")
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("account") String  account,
                          @RequestParam("password") String password,
                          HttpServletRequest request)
    {
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        Subject subject= SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//            UserDto user=(UserDto) subject.getPrincipal();
//            request.getSession().setAttribute(Const.RoleEnum.USER.getRole(),user);
//            return new ResultVOUtil().success();
//        }catch (Exception e)
//        {
//            return new ResultVOUtil().fail("请重新登陆");
//        }
        return userService.login(account,password,request);
    }

//    @GetMapping("/logout")
//    public ResultVO logout()
//    {
//        Subject subject=SecurityUtils.getSubject();
//        if(subject!=null)
//        {
//            subject.logout();
//        }
//        return new ResultVOUtil().success("登出成功");
//    }

    /**
     *
     * @param email
     * @param request
     * @return
     * 修改：先存储一下  要于发送验证码的邮箱对应上（或者让前端来）
     */

    @ApiOperation(value = "发送验证码",notes = "")
    @PostMapping(Const.version+Const.pub+"/sendCode")
    public ResultVO sendCode(@RequestParam("email") String email,HttpServletRequest request)
    {
        try {
            String code= MailUtil.run(email);
            if(code==null)
                return new ResultVOUtil().fail("邮件发送失败");
            else
            {
                HttpSession session=request.getSession(true);//若当前存在Session则返回该会话，否则新建一个Session;
                session.setAttribute("code",code);
                return new ResultVOUtil().fail("邮件发送成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultVOUtil().unknownError();
        }
    }

    @ApiOperation(value = "注册用户",notes = "")
    @PostMapping(Const.version+Const.pub+"/user")
    public ResultVO addUser( UserVO userVO,HttpServletRequest request)
    {
        String code=(String)request.getSession().getAttribute("code");
        if(userVO.code.equals(code))
        {
            User user= CopyProperties.copy(userVO,User.class);
            user.setIsActive(1);
            user.setUserId(IDUtil.getUUID());
            return userService.addUser(user);
        }else
            return new ResultVOUtil().fail("验证码不正确");
    }

    /**
     * Description:删除用户
     * @author yj
     * CreateTime 20:52 2019/11/6
     **/
    @ApiOperation(value = "删除用户",notes = " ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "string",paramType = "query")
    })
    @DeleteMapping(Const.version+Const.unpublic+"/user/{id}")
    public ResultVO addUser(@PathVariable("id") String id,
                            HttpServletRequest request)
    {
        return userService.delUser(id,request);
    }

    /**
     * Description:修改用户信息
     * @author yj
     * CreateTime 20:52 2019/11/6
     **/
    @ApiOperation(value = "修改用户信息",notes = " ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "email",value = "用户邮箱",required = true,dataType = "string",paramType = "query")
    })
    @PutMapping(Const.version+Const.unpublic+"/user/{id}")
    public ResultVO updateUser(@PathVariable("id") String id,
                               @RequestParam("username") String  username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                            HttpServletRequest request)
    {
        return userService.updateUser(id,username,password,email,request);
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "获取某个人的信息",notes = "")
    public ResultVO getUser(@PathVariable("id") String id)
    {
        return userService.getUserById(id);

    }
}
