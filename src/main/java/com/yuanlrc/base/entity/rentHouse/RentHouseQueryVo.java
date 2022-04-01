package com.yuanlrc.base.entity.rentHouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 租房多条件查询vo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentHouseQueryVo {

    private String province;//省

    private String city;//市

    private String district;//区

    private Integer rentHouseWay; //租房方式

    private List<Integer> priceList; //价格

    private List<Integer> houseTypeList; //户型

    private List<Integer> houseOrientationList; //朝向

    private List<Integer> rentHouseFeaturesList; //特色

    private List<Integer> leaseTypeList; //租期

    private List<Integer> floorTypeList; //楼层

    private List<Integer> elevatorList; //电梯

    private String defaultSort; //默认排序

    private String newReleases; //最新上架排序

    private String priceSort; //价格排序

    private String areaSort; //面积排序

    private String search; //搜索


}
