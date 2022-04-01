package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 有无电梯
 */

public enum HouseElevatorEnum {
    HAVING(0,"有电梯"),
    NOTHING(1,"无电梯");

    private Integer code;
    private String name;

    HouseElevatorEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseElevatorEnum value : HouseElevatorEnum.values()){
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
