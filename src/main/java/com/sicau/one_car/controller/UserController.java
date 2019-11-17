package com.sicau.one_car.controller;

import com.sicau.one_car.entity.vo.ResultVO;
import com.sicau.one_car.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType = "string",paramType = "query")
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String  username,
                          @RequestParam("password") String password,
                          HttpServletRequest request)
    {
        return userService.login(username,password,request);
    }

    /**
     * Description:增加用户
     * @author yj
     * CreateTime 20:41 2019/11/6
     **/
    @ApiOperation(value = "注册用户",notes = " ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "email",value = "用户邮箱",required = true,dataType = "string",paramType = "query")
    })
    @PostMapping("/unpub/user")
    public ResultVO addUser(@RequestParam("username") String  username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          HttpServletRequest request)
    {
        return userService.addUser(username,password,email,request);
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
    @GetMapping("/unpub/user/{id}")
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
    @PutMapping("/unpub/user/{id}")
    public ResultVO updateUser(@PathVariable("id") String id,
                               @RequestParam("username") String  username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                            HttpServletRequest request)
    {
        return userService.updateUser(id,username,password,email,request);
    }
}
