package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 房屋朝向
 */
public enum HouseOrientationEnum {
    EAST(0,"朝东"),
    SOUTH(1,"朝南"),
    WEST(2,"朝西"),
    NORTH(3,"朝北"),
    NORTHANDSOUTH(4,"南北");

    private Integer code;
    private String name;

    HouseOrientationEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getByCode(int code){
        for (HouseOrientationEnum value : HouseOrientationEnum.values()){
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
