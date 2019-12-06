package com.sicau.one_car.filter.shiro;

import com.sicau.one_car.dao.UserDao;
import com.sicau.one_car.entity.dto.RoleDto;
import com.sicau.one_car.entity.dto.UserDto;
import com.sicau.one_car.entity.po.Permission;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:继承AuthorizingRealm类进行认证授权
 * @author tzw
 * CreateTime 10:03 2019/11/24
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //通过该类的方法取出（从session里获取用户）
        UserDto user=(UserDto) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList=new ArrayList<>();
        Set<RoleDto> roleDtos=user.getRoleDtos();
        if(CollectionUtils.isEmpty(roleDtos))
        {
            for(RoleDto roleDto:roleDtos)
            {
                Set<Permission> permissionsSet=roleDto.getPermissions();
                if(CollectionUtils.isEmpty(permissionsSet))
                {
                    for (Permission permission:permissionsSet)
                    {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        return info;
    }

    /**
     * 认证登陆
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken  usernamePasswordToken=(UsernamePasswordToken) authenticationToken;
        String username=usernamePasswordToken.getUsername();
        UserDto user=userDao.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
