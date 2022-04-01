package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 面积
 */
public enum HouseAreaEnum {
    UNDERFIFTY(0,"50㎡以下"),
    FIFTYTOSEVENTY(1,"50-70㎡"),
    SEVENTYTONINETY(2,"70-90㎡"),
    NINETYTOONEHUNDREDONE(3,"90-110㎡"),
    ONEHUNDREDONETOONEHUNDREDTHREE(4,"110-130㎡"),
    ONEHUNDREDTHREETOONEHUNDREDFIVE(5,"130-150㎡");


    private Integer code;
    private String name;

    HouseAreaEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseAreaEnum value : HouseAreaEnum.values()){
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
