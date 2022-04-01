package com.yuanlrc.base.entity.bridalChamber;

/**
 * 开盘时间
 */
public enum OpeningTimeEnum {

    RECENTLYOPENED(0,"近期开盘"),
    NEXTMONTH(1,"未来一个月"),
    NEXTTHREEMONTHS(2,"未来三个月"),
    THENEXTSIXMONTHS(3,"未来半年"),
    FORTHEPASTMONTH(4,"过去一个月"),
    FORTHEPASTTHREEMONTHS(5,"过去三个月");

    private Integer code;
    private String name;

    OpeningTimeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getByCode(int code){
        for (OpeningTimeEnum value : OpeningTimeEnum.values()){
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

