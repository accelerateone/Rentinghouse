package com.yuanlrc.base.entity.houseInfoEnum;

/**
 * 楼层
 */

public enum HouseFloorEnum {
    LOW(0,"低楼层"), //10以下
    MIDDLE(1,"中楼层"),//10-20
    HIGH(2,"高楼层");//20以上

    private Integer code;
    private String name;

    HouseFloorEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (HouseFloorEnum value : HouseFloorEnum.values()){
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
