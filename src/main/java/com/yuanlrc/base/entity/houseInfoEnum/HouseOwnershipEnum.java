package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 权属
 */

public enum HouseOwnershipEnum {
    COMMERCIAL(0,"商品房"),
    PUBLIC(1,"公房"),
    AFFORDABLE(2,"经适房"),
    OTHER(1,"其他");

    private Integer code;
    private String name;

    HouseOwnershipEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseOwnershipEnum value : HouseOwnershipEnum.values()){
            if (code == value.getCode()){
                return value.getName();
            }
        }
        return null;
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
