package com.sicau.one_car.entity.dto;

import com.sicau.one_car.entity.po.Permission;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author tzw
 * CreateTime 10:07 2019/11/24
 **/
public class RoleDto {

    private Integer roleId;

    private String roleName;

    private Set<Permission> permissions= new HashSet<>();

    private Set<UserDto> userDtos=new HashSet<>();

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(Set<UserDto> userDtos) {
        this.userDtos = userDtos;
    }
}
