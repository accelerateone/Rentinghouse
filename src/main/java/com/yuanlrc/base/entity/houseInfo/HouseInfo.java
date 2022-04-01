package com.yuanlrc.base.entity.houseInfo;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.houseInfoEnum.*;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 房屋信息
 */
@Entity
@Table(name="ylrc_house_info")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HouseInfo extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "housing_estate_id")
    @ValidateEntity(required=true, errorRequiredMsg="所在小区不能为空!")
    private HousingEstate housingEstate;//小区

    @ManyToOne
    @ValidateEntity(required=true, errorRequiredMsg="顾问不能为空!")
    @JoinColumn(name="roconsultant_id")
    private User roconsultant; //所属顾问

    @ValidateEntity(required=true, errorRequiredMsg="封面图不能为空!")
    @Column(name="cover_pic",nullable=false)
    private String coverPic; //封面图

    @ValidateEntity(required=true, errorRequiredMsg="详情图不能为空!")
    @Column(name="details_pics",nullable=false)
    private String detailsPics;//租房详情图片

    @Column(name="province",nullable=false,length=18)
    private String province;  //省

    @Column(name="city",nullable=false)
    private String city; //市

    @Column(name="district",nullable=false)
    private String district; //区

    @ValidateEntity(required=true,requiredLeng=true,maxLength=600,errorRequiredMsg="房型描述信息不能为空!",
            errorMaxLengthMsg="房型描述信息长度不能大于100!")
    @Column(name="house_type_describe",nullable=false)
    private String houseTypeDescribe;//房型描述

    @ValidateEntity(required=true,requiredLeng=true,maxLength=200,errorRequiredMsg="户型介绍不能为空!",
            errorMaxLengthMsg="户型介绍长度不能大于600!")
    @Column(name="house_introduce",nullable=false)
    private String houseIntroduce;//户型介绍

    @ValidateEntity(required=true,requiredMinValue=true,requiredMaxValue = true,minValue=0,maxValue=10000,
            errorRequiredMsg="房间面积不能为空!",errorMinValueMsg="房间面积最小为0㎡!",errorMaxValueMsg="房间面积最大为10000㎡!")
    @Column(name="area")
    private Double area;//房间面积 enum

    @ValidateEntity(required=true,requiredMinValue=true,requiredMaxValue = true,minValue=1,maxValue=1000,
            errorRequiredMsg="房屋所在楼层不能为空!",errorMinValueMsg="房屋所在楼层最小为1!",errorMaxValueMsg="房屋所在楼层最大为1000!")
    @Column(name="floor",nullable=false)
    private Integer floor;//所在楼层 enum

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=100,
            errorRequiredMsg="梯户比例描述不能为空!",errorMinLengthMsg="梯户比例描述长度不能小于2!",errorMaxLengthMsg="梯户比例描述长度不能大于100!")
    @Column(name="scale",nullable=false)
    private String scale;//梯户比例描述

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=100,
            errorRequiredMsg="卖点不能为空!",errorMinLengthMsg="卖点长度不能小于2!",errorMaxLengthMsg="卖点长度不能大于100!")
    @Column(name="selling_point",nullable=false)
    private String sellingPoint;//卖点

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=300,
            errorRequiredMsg="房屋详情介绍不能为空!",errorMinLengthMsg="房屋详情介绍长度不能小于2!",errorMaxLengthMsg="房屋详情介绍长度不能大于300!")
    @Column(name="details",nullable=false)
    private String details;//房屋详情介绍

    @ValidateEntity(required=true,requiredMinValue=true,requiredMaxValue = true,minValue=0,maxValue=10000,
            errorRequiredMsg="楼龄不能为空!",errorMinValueMsg="楼龄最小为0!",errorMaxValueMsg="楼龄最大为10000!")
    @Column(name="building_age",nullable=false)
    private Integer buildingAge;//楼龄 enum

    @ValidateEntity(required=true,requiredMinValue=true,requiredMaxValue = true,minValue=1,maxValue=10000,
            errorRequiredMsg="楼栋号不能为空!",errorMinValueMsg="楼栋号最下为1!")
    @Column(name="building_number",nullable=false)
    private Integer buildingNumber;//楼栋号

    @ValidateEntity(required=true,requiredLeng=true,maxLength = 5,
            errorRequiredMsg="房间号不能为空!",errorMaxLengthMsg="房屋号最大长度不能超过5!")
    @Column(name="house_number",nullable=false)
    private String houseNumber;//房屋号

    @ValidateEntity(required=false)
    @Column(name="watch_number",nullable=false)
    private Integer watchNumber = 0;//背带看次数

    @ValidateEntity(required=true,requiredMinValue=true,requiredMaxValue = true,minValue=0,maxValue=100000,
            errorRequiredMsg="具体售价(总价)不能为空!",errorMinValueMsg="具体售价(总价)最小为0万元",errorMaxValueMsg="具体售价(总价)最大为10亿")
    @Column(name="specific_price",nullable=false)
    private Double specificPrice;//具体售价 (总价) 单位/万 enum

    @Column(name="unit_price",nullable=false)
    private Double unitPrice;//单价

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=200,
            errorRequiredMsg="抵押信息描述不能为空!",errorMinLengthMsg="抵押信息描述长度不能小于2!",errorMaxLengthMsg="抵押信息描述长度不能大于200!")
    @Column(name="mortgage_info",nullable=false)
    private String mortgageInfo;//抵押信息描述

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=100,
            errorRequiredMsg="房屋年限描述不能为空!",errorMinLengthMsg="房屋年限描述长度不能小于2!",errorMaxLengthMsg="房屋年限描述不能大于100!")
    @Column(name="housing_years",nullable=false)
    private String housingYears;//房屋年限描述

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=100,
            errorRequiredMsg="看房时间不能为空!",errorMinLengthMsg="看房时间长度不能小于2!",errorMaxLengthMsg="看房时间不能大于100!")
    @Column(name="open_home",nullable=false)
    private String openHome;//看房时间

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=100,
            errorRequiredMsg="装修描述不能为空!",errorMinLengthMsg="装修描述长度不能小于2!",errorMaxLengthMsg="装修描述不能大于100!")
    @Column(name="decoration_description",nullable=false)
    private String decorationDescription;//装修描述

    @ManyToMany(targetEntity = HouseLabel.class,fetch = FetchType.EAGER)
    @Column(name="house_label")
    private List<HouseLabel> houseLabel;//房屋标签

    @Enumerated
    @Column(name="house_type")
    private HouseTypeEnum houseType;//房型

    @Enumerated
    @Column(name="house_orientation")
    private HouseOrientationEnum houseOrientation;//房屋朝向

    @Enumerated
    @Column(name="house_renovation")
    private HouseRenovationEnum houseRenovation;//房屋装修

    @Enumerated
    @Column(name="house_purpose")
    private HousePurposeEnum housePurpose;//房屋用途

    @Enumerated
    @Column(name="house_elevator")
    private HouseElevatorEnum houseElevator;//有无电梯

    @Enumerated
    @Column(name="house_ownership")
    private HouseOwnershipEnum houseOwnership;//房屋权属

    @Enumerated
    @Column(name="house_architecture_type")
    private HouseArchitectureTypeEnum houseArchitectureType;//建筑类型

    @Enumerated
    @Column(name="house_sales")
    private HouseSalesEnum houseSales;//房屋出售情况



}
