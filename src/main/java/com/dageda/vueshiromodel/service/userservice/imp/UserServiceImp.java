package com.dageda.vueshiromodel.service.userservice.imp;

import com.dageda.vueshiromodel.dao.UserMapper;
import com.dageda.vueshiromodel.entity.shiro.LoginInfo;
import com.dageda.vueshiromodel.entity.shiro.Permission;
import com.dageda.vueshiromodel.entity.shiro.Role;
import com.dageda.vueshiromodel.entity.shiro.User;
import com.dageda.vueshiromodel.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserServiceImp
 * @Description:
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User judgeLog(String nickname) {
        return userMapper.judgeLog(nickname);
    }

    @Override
    public List<Permission> getMenusByHrId(Integer id) {
        return userMapper.getMenusByHrId(id);
    }

    @Override
    public List<Role> findRolesByUserName(Integer id) {
        return userMapper.findRolesByUserName(id);
    }

    @Override
    public LoginInfo getLoginInfo(Integer id) {
        List<Role> roles = userMapper.findRolesByUserName(id);
        List<Permission> permissions  = userMapper.getMenusByHrId(id);
        Set<String> roleList = new HashSet<>();
        Set<String> permissionList = new HashSet<>();
        for (Role role : roles) {
            //角色存储
            roleList.add(role.getName());
        }
        for (Permission perm : permissions) {
            //权限存储
            permissionList.add(perm.getUrl());
        }
        return new LoginInfo(roleList,permissionList);
    }
}
