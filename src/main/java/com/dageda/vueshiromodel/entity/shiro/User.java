package com.dageda.vueshiromodel.entity.shiro;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description: 用户类    该类是需要反序列化的 必须实现Serializable接口
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
public class User implements Serializable {
    private Integer id;
    /** 用户账号 */
    private String nickname;
    /** 用户邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 创建日期 */
    private Date createTime;
    /** 最后登录日期 */
    private Date lastLoginTime;
    /** 账号状态 */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
