package com.yuanlrc.base.entity.bridalChamber;

/**
 * 装修状态
 */
public enum DecorateStateEnum {

    TAKEDECORATING(0,"带装修"),
    WORKBLANK(1,"毛坯");

    private Integer code;
    private String name;

    DecorateStateEnum(Integer code, String name) {
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
