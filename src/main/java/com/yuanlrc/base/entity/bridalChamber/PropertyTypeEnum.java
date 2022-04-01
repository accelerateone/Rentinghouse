package com.yuanlrc.base.entity.bridalChamber;

/**
 * 物业类型
 */
public enum  PropertyTypeEnum {

    RESIDENCE(0,"住宅"),
    VILLA(1,"别墅"),
    OFFICEBUILDING(2,"写字楼"),
    COMMERCE(3,"商业"),
    BASEBUSINESS(4,"底商");

    private Integer code;

    private String name;

    PropertyTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

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
}
