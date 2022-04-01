package com.yuanlrc.base.entity.housingEstate;

/**
 * 小区均价枚举
 * @author wangzihan
 * @date : 2021/1/7 11:28
 */

public enum  AveragePriceEnum {

    LESSTHANTHREE(0,"3万以下"),
    THREETOFOUR(1,"3-4万"),
    FOURTOFIVE(2,"4-5万"),
    FIVETOSIX(3,"5-6万"),
    SIXTOSEVEN(4,"6-7万"),
    MORETHANSEVEN(5,"7万以上");


    private Integer code;
    private String name;

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

    AveragePriceEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


}
