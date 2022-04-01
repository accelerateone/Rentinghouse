package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 出售情况
 */
public enum  HouseSalesEnum {
    ONSALE(0,"在售"),
    DEAL(1,"成交");

    private Integer code;
    private String name;

    HouseSalesEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseSalesEnum value : HouseSalesEnum.values()){
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
