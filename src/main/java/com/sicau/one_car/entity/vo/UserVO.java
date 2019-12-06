package com.sicau.one_car.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 15:46 2019/11/28
 **/
@ApiModel
public class UserVO {

    @ApiModelProperty(value = "用户名",example = "田子玮")
    public String username;

    @ApiModelProperty(value = "密码",example = "123456")
    public String password;

    @ApiModelProperty(value = "邮箱",example = "tzw1339502082@qq.com")
    public String email;

    @ApiModelProperty(value = "验证码",example = "sd2d25s")
    public String code;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
