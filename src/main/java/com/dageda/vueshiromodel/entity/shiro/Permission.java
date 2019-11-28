package com.dageda.vueshiromodel.entity.shiro;

/**
 * @ClassName Permission
 * @Description: 权限实体类
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
public class Permission {
    private Integer id;
    /** url地址 */
    private String url;
    /** url描述 */
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Permission() {
    }

    public Permission(Integer id, String url, String describe) {
        this.id = id;
        this.url = url;
        this.describe = describe;
    }
}
