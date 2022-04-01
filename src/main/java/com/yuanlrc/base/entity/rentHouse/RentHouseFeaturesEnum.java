package com.yuanlrc.base.entity.rentHouse;

/**
 * 租房特色枚举
 */
public enum  RentHouseFeaturesEnum {

    INTHESUBWAY(0,"近地铁"),
    BAGIN(1,"拎包入住"),
    FINEDECORATION(2,"精装修"),
    APAY(3,"押一付一"),
    ONTHENEW(4,"新上"),
    CERTIOFAPART(5,"认证公寓"),
    ATANYTIMETOSEE(6,"随时看房"),
    OWNEROFRECOM(7,"业主自荐");

    private Integer code;
    private String name;

    RentHouseFeaturesEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (RentHouseFeaturesEnum value : RentHouseFeaturesEnum.values()){
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
