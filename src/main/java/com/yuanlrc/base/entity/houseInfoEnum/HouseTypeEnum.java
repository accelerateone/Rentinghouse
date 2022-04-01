package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 房型
 */

public enum HouseTypeEnum {
    ONEROOM(0,"一室"),
    TWOROOM(1,"二室"),
    THREEROOM(2,"三室"),
    FOURROOM(3,"四室"),
    FIVEROOM(4,"五室"),
    MANYROOM(5,"五室++");

    private Integer code;
    private String name;

    HouseTypeEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseTypeEnum value : HouseTypeEnum.values()){
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
