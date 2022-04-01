package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 装修
 */

public enum HouseRenovationEnum {
    REFINED(0,"精装修"),
    ORDINARY(1,"普通装修"),
    ROUGH(2,"毛坯房");

    private Integer code;
    private String name;

    HouseRenovationEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseRenovationEnum value : HouseRenovationEnum.values()){
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
