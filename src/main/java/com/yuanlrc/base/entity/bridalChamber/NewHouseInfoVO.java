package com.yuanlrc.base.entity.bridalChamber;

import lombok.Data;

import java.util.List;
@Data
public class NewHouseInfoVO {

    List<Integer> decorateStateCodeList;    //装修状态
    List<Integer> openingTimeCodeList;  //开盘时间
    List<Integer> propertyTypeCodeList; //物业类型
    List<Integer> sellingTheStateCodeList;  //售卖状态
    Double builtUpAreaMinValue; //面积最小值
    Double builtUpAreaMaxValue; //面积最大值
    Double moneyMinValue; //金钱最小值
    Double moneyMaxValue; //金钱最大值
    String city;    //城市
    Integer averagePriceSort;   //均将排序
    Integer latestOpeningHoursSort; //开盘时间排序
    String name;

}
