package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 建筑类型
 */

public enum HouseArchitectureTypeEnum {
    TOWER(0,"塔楼"),
    PLATE(1,"板楼"),
    PLATETOWER(2,"板塔结合");

    private Integer code;
    private String name;

    HouseArchitectureTypeEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseArchitectureTypeEnum value : HouseArchitectureTypeEnum.values()){
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
