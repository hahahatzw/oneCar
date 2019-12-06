package com.sicau.one_car.filter.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Description:token里的password与数据库password进行对比（info为AuthRealm的AuthenticationInfo）
 * @author tzw
 * CreateTime 10:58 2019/11/24
 **/
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
        String password=new String(usernamePasswordToken.getPassword());
        String dbpassword=(String)info.getCredentials();

        return this.equals(password,dbpassword);
    }
}
