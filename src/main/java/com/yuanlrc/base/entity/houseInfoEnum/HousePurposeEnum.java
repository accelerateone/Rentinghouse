package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 用途
 */

public enum HousePurposeEnum {
    RESIDENCE(0,"普通住宅"),
    BUSINESS(1,"商业类"),
    VILLA(2,"别墅"),
    COURTYARD(3,"四合院"),
    OTHER(4,"其他");

    private Integer code;
    private String name;

    HousePurposeEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HousePurposeEnum value : HousePurposeEnum.values()){
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
