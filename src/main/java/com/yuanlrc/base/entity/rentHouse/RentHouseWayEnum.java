package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房方式枚举
 */
public enum RentHouseWayEnum {

    WHOLERENT(0,"整租"),
    ROOMMATES(1,"合租");


    private Integer code;
    private String name;

    RentHouseWayEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (RentHouseWayEnum value : RentHouseWayEnum.values()){
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
