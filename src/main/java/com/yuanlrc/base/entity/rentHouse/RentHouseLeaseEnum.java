package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房租期枚举
 */
public enum RentHouseLeaseEnum {

    MONTH(0,"月租"),
    YAER(1,"年租"),
    ONETOTHREE(2,"1-3个月"),
    FOURTOSIX(3,"4-6个月");


    private Integer code;
    private String name;

    RentHouseLeaseEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (RentHouseLeaseEnum value : RentHouseLeaseEnum.values()){
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
