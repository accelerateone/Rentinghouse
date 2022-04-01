package com.yuanlrc.base.entity.houseInfoEnum;

public enum PriceEnum {
    TWOUP(0,"200万以下"),
    TWOTOTHREE(1,"200-300万"),
    THREETOFOUR(2,"300-400万"),
    FOURTOFIVE(3,"400-500万"),
    FIVETOEIGTH(4,"500-800万"),
    EIGHTTOTEN(5,"800-1000万");


    private Integer code;
    private String name;

    PriceEnum(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public static String getByCode(int code){
        for (PriceEnum value : PriceEnum.values()){
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
