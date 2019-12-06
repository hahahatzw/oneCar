package com.sicau.one_car.filter.shiro;


import com.sicau.one_car.common.Const;
import com.sicau.one_car.filter.shiro.AuthRealm;
import com.sicau.one_car.filter.shiro.CredentialMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Description:shiro核心配置
 * 将AuthRealm、CredentialsMacher注入至shiro容器里
 * @author tzw
 * CreateTime 11:01 2019/11/24
 **/

//@Configuration
public class ShiroConfiguration {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager)
    {
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(manager);

//        shiroFilter.setLoginUrl("/login");
//        shiroFilter.setSuccessUrl("/index");
//        shiroFilter.setUnauthorizedUrl("/unauthorized");

        /**
         * 权限配置
         */
        LinkedHashMap<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put(Const.version+Const.unpublic+"/**","authc");//必须登陆   DefaultFilter
        filterChainDefinitionMap.put("/login","anon");//不需要登陆
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(AuthRealm authRealm)
    {
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }


    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher)
    {
        AuthRealm authRealm=new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);//给出自己的密码比较器
        return authRealm;
    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher()
    {
        return new CredentialMatcher();
    }

    /**
     * shiro与spring关联
     * @param manager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager)
    {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}

