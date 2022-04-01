package com.yuanlrc.base.entity.bridalChamber;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.admin.User;
import lombok.Data;
import lombok.ToString;
import org.hibernate.mapping.ToOne;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 楼盘信息
 */
@Entity
@Table(name="ylrc_new_house_info")
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class NewHouseInfo extends BaseEntity {

    @ValidateEntity(required=true,errorRequiredMsg="请上传效果图!")
    @Column(name="first_figure_path",nullable=false,length=90)
    private String firstFigurePath; //效果图路径

    @ValidateEntity(required=false)
    @ManyToMany
    @Column(name="effect_picture_items")
    private List<EffectPicture> effectPictureItems;    //详细图路径

    @ValidateEntity(required=true,errorRequiredMsg="省不能为空!")
    @Column(name="province",nullable=false,length=20)
    private String province;    //省

    @ValidateEntity(required=true,errorRequiredMsg="市不能为空!")
    @Column(name="city",nullable=false,length=20)
    private String city;  //市

    @ValidateEntity(required=true,errorRequiredMsg="区不能为空!")
    @Column(name="district",nullable=false,length=20)
    private String district;    //区

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=60,errorRequiredMsg="详细地址不能为空!",errorMinLengthMsg="详细地址长度需大于1!",errorMaxLengthMsg="详细地址长度不能大于60!")
    @Column(name="detailed_address",nullable=false,length=60)
    private String detailedAddress;//详细地址

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=10,errorRequiredMsg="楼盘名称不能为空!",errorMinLengthMsg="楼盘名称长度需大于1!",errorMaxLengthMsg="楼盘名称长度不能大于10!")
    @Column(name="name",nullable=false,length=10)
    private String name;    //名称


    @ValidateEntity(required=true,requiredMaxValue=true,requiredMinValue = true,minValue=1,maxValue=100000,errorRequiredMsg="建成面积不能为空!",errorMinValueMsg="建成面积不能小于1平方!",errorMaxValueMsg="建成面积不能超过100000平方!")
    @Column(name="built_up_area",nullable=false)
    private Double builtUpArea; //建成面积

    @ValidateEntity(required=true,requiredMaxValue=true,requiredMinValue = true,minValue=1,maxValue=500000,errorRequiredMsg="均价不能为空!",errorMinValueMsg="均价不能小于1元!",errorMaxValueMsg="均价不能超过500000元!")
    @Column(name="average_price",nullable=false)
    private Double averagePrice;    //均价(单价)

    /**
     * Hibernate JPA 实体类时间注解 - @Temporal
     * 如果在某类中有Date类型的属性，数据库中存储可能是’yyyy-MM-dd hh:MM:ss’要在查询时获得年月日，在该属性上标注@Temporal(TemporalType.DATE) 会得到形如’yyyy-MM-dd’ 格式的日期。
     * 如果在某类中有Date类型的属性，数据库中存储可能是’yyyy-MM-dd hh:MM:ss’要获得时分秒，在该属性上标注 @Temporal(TemporalType.TIME) 会得到形如’HH:MM:SS’ 格式的日期。
     * 如果在某类中有Date类型的属性，数据库中存储可能是’yyyy-MM-dd hh:MM:ss’要获得’是’yyyy-MM-dd hh:MM:ss’，在该属性上标注 @Temporal(TemporalType.TIMESTAMP) 会得到形如’yyyy-MM-dd hh:MM:ss’ 格式的日期
     */
    @ValidateEntity(required=true,errorRequiredMsg="最新开盘时间不能为空!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "latest_opening_hours")
    private Date latestOpeningHours;    //最新开盘时间

    @ValidateEntity(required=true,errorRequiredMsg="项目特色不能为空!")
    @Column(name="housing_characteristics_list")
    @ManyToMany
    private List<HousingCharacteristics> housingCharacteristicsList;//楼盘所对应的特色列表

    @ValidateEntity(required=true,errorRequiredMsg="负责经纪人不能为空!")
    @Column(name="users_id")
    @ManyToMany
    private List<User> users;//楼盘所对应的负责人列表

    @ValidateEntity(required=true,errorRequiredMsg="负责顾问不能为空!")
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;  //楼盘所对应顾问

    @ValidateEntity(required=true,errorRequiredMsg="经纬度不能为空!")
    @Column(name="longitude_and_latitude",nullable=false)
    private String longitudeAndIatitude;  // 百度地图经纬度

    @ValidateEntity(required=true,errorRequiredMsg="装修状态不能为空!")
    @Enumerated
    @Column(name="decorate_state")
    private DecorateStateEnum decorateState;//装修状态

    @ValidateEntity(required=true,errorRequiredMsg="开盘时间不能为空!")
    @Enumerated
    @Column(name="opening_time")
    private OpeningTimeEnum openingTime;//开盘时间

    @ValidateEntity(required=true,errorRequiredMsg="物业类型不能为空!")
    @Enumerated
    @Column(name="property_type")
    private PropertyTypeEnum propertyType;//物业类型

    @ValidateEntity(required=true,errorRequiredMsg="售卖状态不能为空!")
    @Enumerated
    @Column(name="selling_the_state")
    private SellingTheStateEnum sellingTheState;//售卖状态



}
