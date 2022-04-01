package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房电梯枚举
 */
public enum RentHouseElevatorEnum {

    HAVE(0,"有电梯"),
    NO(1,"无电梯");


    private Integer code;
    private String name;

    RentHouseElevatorEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (RentHouseElevatorEnum value : RentHouseElevatorEnum.values()){
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
