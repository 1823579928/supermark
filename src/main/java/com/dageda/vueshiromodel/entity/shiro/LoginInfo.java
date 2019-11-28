package com.dageda.vueshiromodel.entity.shiro;

import java.util.List;
import java.util.Set;

/**
 * @ClassName LoginInfo
 * @Description: 储存角色权限
 * @Author 邹捷
 * @Date 2019/11/25
 * @Version V1.0
 **/
public class LoginInfo {
    /**
     * 用户角色集合
     */
    private Set roleList;
    /**
     * 用户权限集合
     */
    private Set permissionList;

    public LoginInfo() {
    }

    public Set getRoleList() {
        return roleList;
    }

    public void setRoleList(Set roleList) {
        this.roleList = roleList;
    }

    public LoginInfo(Set roleList, Set permissionList) {
        this.roleList = roleList;
        this.permissionList = permissionList;
    }

    public Set getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set permissionList) {
        this.permissionList = permissionList;
    }
}
