package com.yuanlrc.base.entity.admin;

/**
 * 用户角色类型枚举
 * @author wangzihan
 * @date : 2021/1/8 13:20
 */
public enum UserRoleTypeEnum {

    ADMIN(0,"管理员"),
    CONSULTANT(1,"顾问"),
    AGENT(2,"经纪人");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UserRoleTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
