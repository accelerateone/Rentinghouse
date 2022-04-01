package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 房龄
 */
public enum HouseAgeEnum {

    FIVEYEAR(0,"5年以内"),
    TENYEAR(1,"10年以内"),
    FIFTEENTYEAR(2,"15年以内"),
    TWENTYYEARIN(3,"20年以内"),
    TWENTYYEARUP(4,"20年以上");


    private Integer code;
    private String name;

    HouseAgeEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseAgeEnum value : HouseAgeEnum.values()){
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
