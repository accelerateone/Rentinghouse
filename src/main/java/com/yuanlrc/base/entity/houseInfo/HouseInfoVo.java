package com.yuanlrc.base.entity.houseInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class HouseInfoVo {
    String province;//省
    String city;//市
    String district;//区
    List<Integer> housePrice;//售价
    List<Integer> houseType;//房型
    List<Integer> houseArea;//面积
    List<Integer> houseLabel;//标签id
    List<Integer> houseOrientation;//朝向
    List<Integer> houseFloor;//楼层
    List<Integer> houseAge;//楼龄
    List<Integer> houseRenovation;//装修
    List<Integer> housePurpose;//用途
    List<Integer> houseElevator;//电梯
    List<Integer> houseOwnership;//权属
    List<Integer> houseArchitectureType;//建筑类型
    Integer houseSales;//房屋出售情况
    Integer createTimeSort;//最新发布排序
    Integer specificPriceSort;//按照总价排序  1升序 2降序
    Integer unitPriceSort;//按照单价排序  1升序 2降序
    Integer areaSort;//按照面积排序  1升序 2降序
    String search; //搜索
}
