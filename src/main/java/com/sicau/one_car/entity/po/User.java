package com.sicau.one_car.entity.po;

/**
 * Description:用户实体类
 * @author tzw
 * CreateTime 16:22 2019/11/2
 **/
public class User {

    private String userId;

    private String username;

    private String password;

    private String email;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
}
