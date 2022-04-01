package com.yuanlrc.base.entity.houseInfoEnum;

public enum  HouseDivisionWindowEnum {
    COMMON(0,"普通窗"),
    FRENCH(1,"落地窗"),
    WINDOWLESS(2,"无窗"),
    UNKNOWN(3,"未知窗户类型");

    private Integer code;
    private String name;

    HouseDivisionWindowEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseDivisionWindowEnum value : HouseDivisionWindowEnum.values()){
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
