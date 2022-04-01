package com.yuanlrc.base.entity.bridalChamber;

/**
 * 售卖状态
 */
public enum SellingTheStateEnum {

    FORSALE(0,"在售"),
    DIDNOTOPEN(1,"未开盘"),
    SELLOUT(2,"售完");

    private Integer code;
    private String name;

    SellingTheStateEnum(Integer code, String name) {
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
