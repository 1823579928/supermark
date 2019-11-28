package com.dageda.vueshiromodel.dao;

import com.dageda.vueshiromodel.entity.shiro.Permission;
import com.dageda.vueshiromodel.entity.shiro.Role;
import com.dageda.vueshiromodel.entity.shiro.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: 权限管理接口
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
@Repository
public interface UserMapper {
    /**
     *  登录验证
     * @param nickname  用户名
     * @return      user实体类
     */
    User judgeLog(@Param("nickname")String nickname);

    /**
     * 获取权限集合
     * @param id    用户id
     * @return    权限集合
     */
    List<Permission> getMenusByHrId(@Param("id")Integer id);

    /**
     * 获取角色集合
     * @param id    用户id
     * @return      角色集合
     */
    List<Role> findRolesByUserName(@Param("id")Integer id);
}
