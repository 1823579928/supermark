package com.dageda.vueshiromodel.entity.shiro;

/**
 * @ClassName Role
 * @Description: 角色实体类
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
public class Role {
    private Integer id;
    /** 角色名称 */
    private String name;
    /** 角色类型 */
    private String type;

    public Role() {
    }

    public Role(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
