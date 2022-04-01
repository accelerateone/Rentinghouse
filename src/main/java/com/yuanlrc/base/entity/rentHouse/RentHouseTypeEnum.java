package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房户型枚举
 */
public enum RentHouseTypeEnum {

    ONEROOM(0,"1居"),
    TWOROOM(1,"2居"),
    THREEROOM(2,"3居"),
    FOURROOM(3,"4居+");

    private Integer code;
    private String name;

    RentHouseTypeEnum (Integer code,String name){
        this.code=code;
        this.name=name;
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
