package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房价格枚举
 */
public enum  RentHoursePriceEnum {

    LESSONE(0,"1000以下"),
    ONETOONEFIVE(1,"1000-1500元"),
    ONEFIVETOTWO(2,"1500-2000元"),
    TWOTOTHREE(3,"2000-3000元"),
    THREETOFIVE(4,"3000-5000元"),
    FIVETOEIGHT(5,"5000-8000元"),
    EIGHTABOVE(6,"8000元以上");


    private Integer code;
    private String name;

    RentHoursePriceEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (RentHoursePriceEnum value : RentHoursePriceEnum.values()){
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
