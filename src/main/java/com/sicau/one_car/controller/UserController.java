package com.sicau.one_car.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:用户信息管理controller层
 * @author tzw
 * CreateTime 20:41 2019/10/25
 **/

@RestController
@Api(value = "用户信息" ,description = "用于用户信息的增删查改")
public class UserController {

    @ApiOperation(value = "用户登陆",notes = " ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType = "string",paramType = "query")
    })
    @GetMapping("/login")
    public String login(@RequestParam("username") String  username,
                        @RequestParam("password") String password)
    {
        return username+password;
    }
}
