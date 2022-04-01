package com.yuanlrc.base.entity.rentHouse;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.houseInfoEnum.HouseFloorEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseOrientationEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.List;

/**
 * 租房实体类
 */
@Entity
@Table(name="ylrc_rent_house")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class RentHouse extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user; //所属发布经纪人

    @ManyToOne
    @ValidateEntity(required=true, errorRequiredMsg="顾问不能为空!")
    @JoinColumn(name="roconsultant_id")
    private User roconsultant; //所属顾问

    @ManyToOne
    @JoinColumn(name="housing_estate")
    @ValidateEntity(required=true, errorRequiredMsg="所在小区不能为空!")
    private HousingEstate housingEstate; //所在小区

    @ValidateEntity(required=true, errorRequiredMsg="省不能为空!")
    @Column(name="province",nullable=false,length=18)
    private String province;  //省

    @ValidateEntity(required=true, errorRequiredMsg="市不能为空!")
    @Column(name="city",nullable=false)
    private String city; //市

    @ValidateEntity(required=true, errorRequiredMsg="区不能为空!")
    @Column(name="district",nullable=false)
    private String district; //区

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=10,
            errorRequiredMsg="镇不能为空!",errorMinLengthMsg="镇长度需大于2!",errorMaxLengthMsg="镇长度不能大于10!")
    @Column(name="town",nullable=false)
    private String town; //镇

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30, errorRequiredMsg="街道不能为空!",
            errorMinLengthMsg="街道长度需大于1!",errorMaxLengthMsg="街道长度不能大于30!")
    @Column(name="street",nullable=false)
    private String street; //具体街道

    @ValidateEntity(required=true, errorRequiredMsg="封面图不能为空!")
    @Column(name="cover_pic",nullable=false)
    private String coverPic; //封面图

    @ValidateEntity(required=true, errorRequiredMsg="详情图不能为空!")
    @Column(name="details_pics",nullable=false)
    private String detailsPics;//租房详情图片

    @ValidateEntity(required=true,requiredMinValue = true,minValue=0,requiredMaxValue = true,maxValue=1000000,
            errorRequiredMsg="价格不能为空!",errorMinValueMsg="价格最小为0元/月!",errorMaxValueMsg="价格最大为1百万/月!")
    @Column(name="price",nullable=false)
    private Integer price; //租价

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30, errorRequiredMsg="房名不能为空!",
            errorMinLengthMsg="房名长度需大于1!",errorMaxLengthMsg="房名长度不能大于30!")
    @Column(name="name",nullable=false)
    private String name; //名称

    @ValidateEntity(required=true,requiredMinValue = true,minValue=0,requiredMaxValue = true,maxValue=10000,
            errorRequiredMsg="房间面积不能为空!",errorMinValueMsg="面积最小为0!",errorMaxValueMsg="面积最大为10000平!")
    @Column(name="area")
    private Integer area;//房间面积

    @ValidateEntity(required=true, errorRequiredMsg="楼层不能为空!")
    @Enumerated
    @Column(name="floor_type",nullable=false)
    private HouseFloorEnum floorType; //楼层类型，高中低层 （枚举）

    @ValidateEntity(required=true,requiredMinValue = true,minValue=1,requiredMaxValue = true,maxValue=10000,
            errorRequiredMsg="具体层不能为空!",errorMinValueMsg="具体层最小为1层!",errorMaxValueMsg="具体层最大为10000层")
    @Column(name="floor",nullable=false)
    private Integer floor;//所在楼层，具体

    @ValidateEntity(required=true, errorRequiredMsg="出租方式不能为空!")
    @Enumerated
    @Column(name="rent_house_way",nullable=false)
    private RentHouseWayEnum rentHouseWay; //出租方式，整合或合租（枚举）

    @ValidateEntity(required=true, errorRequiredMsg="租期类型不能为空!")
    @Enumerated
    @Column(name="lease_type",nullable=false)
    private RentHouseLeaseEnum leaseType; //租期类型（枚举）

    @ValidateEntity(required=true, errorRequiredMsg="租期不能为空!")
    @Column(name="lease",nullable=false)
    private String lease;//具体租期

    @ValidateEntity(required=true, errorRequiredMsg="户型类型不能为空!")
    @Enumerated
    @Column(name="house_type",nullable=false)
    private RentHouseTypeEnum houseType; //户型类型（枚举）

    @ValidateEntity(required=true, errorRequiredMsg="户型不能为空!")
    @Column(name="door_model",nullable=false)
    private String doorModel; //具体户型信息

    @ValidateEntity(required=true, errorRequiredMsg="房屋朝向不能为空!")
    @Enumerated
    @Column(name="house_orientation",nullable=false)
    private HouseOrientationEnum houseOrientation; //朝向(枚举)

    @ValidateEntity(required=true, errorRequiredMsg="有无电梯不能为空!")
    @Enumerated
    @Column(name="elevator",nullable=false)
    private RentHouseElevatorEnum elevator; //有无电梯 （枚举）

    @ValidateEntity(required=true,errorRequiredMsg="房源特色不能为空!")
    @Column(name="rent_house_features_list")
    @ManyToMany
    private List<RentHouseFeatures> rentHouseFeaturesList;//租房所对应的特色列表

    @Column(name="parking_space",nullable=false)
    private String parkingSpace; //车位信息 （选填）

    @Column(name="water",nullable=false)
    private String water; //用水 （选填）

    @Column(name="electricity",nullable=false)
    private String electricity; //用电 （选填）

    @Column(name="fuel_gas",nullable=false)
    private String fuelGas; //燃气（选填）

    @Column(name="heating",nullable=false)
    private String heating; //采暖（选填）

    @Column(name="introduction",nullable=false)
    private String introduction; //介绍信息




}
