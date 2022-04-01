package com.yuanlrc.base.entity.housingEstate;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.admin.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

/**
 * 小区实体类
 * @author wangzihan
 * @date : 2021/1/7 12:53
 */
@Entity
@Table(name="ylrc_housing_estate")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HousingEstate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user; //所属发布经纪人

    @ValidateEntity(required=true, requiredLeng=true,minLength=2,maxLength=10,
            errorRequiredMsg="省不能为空!",errorMinLengthMsg="省长度需大于2!",errorMaxLengthMsg="省长度不能大于10!")
    @Column(name="province",nullable=false,length=18)
    private String province;  //省

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=10,
            errorRequiredMsg="市不能为空!",errorMinLengthMsg="市长度需大于2!",errorMaxLengthMsg="市长度不能大于10!")
    @Column(name="city",nullable=false)
    private String city; //市

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=10,
            errorRequiredMsg="区不能为空!",errorMinLengthMsg="区长度需大于2!",errorMaxLengthMsg="区长度不能大于10!")
    @Column(name="district",nullable=false)
    private String district; //区

    @ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=10,
            errorRequiredMsg="镇不能为空!",errorMinLengthMsg="镇长度需大于2!",errorMaxLengthMsg="镇长度不能大于10!")
    @Column(name="town",nullable=false)
    private String town; //镇

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30, errorRequiredMsg="街道不能为空!",
            errorMinLengthMsg="街道长度需大于1!",errorMaxLengthMsg="街道长度不能大于30!")
    @Column(name="street",nullable=false)
    private String street; //街道

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30, errorRequiredMsg="小区名不能为空!",
            errorMinLengthMsg="小区名长度需大于1!",errorMaxLengthMsg="小区名长度不能大于30!")
    @Column(name="name",nullable=false)
    private String name; //小区名

    @ValidateEntity(required=true,requiredLeng=true,minLength=4,maxLength=4, errorRequiredMsg="建成年代不能为空!",
            errorMinLengthMsg="建成年代长度为4!",errorMaxLengthMsg="建成年代长度为4!")
    @Column(name="completed_year",nullable=false)
    private Integer completedYear;  //建成年代

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=10, errorRequiredMsg="建筑类型不能为空!",
            errorMinLengthMsg="建筑类型长度需大于1!",errorMaxLengthMsg="建筑类型长度不能大于10!")
    @Column(name="building_type",nullable=false)
    private String buildingType; //建筑类型

    @ValidateEntity(required=true, errorRequiredMsg="小区经纬度不能为空!")
    @Column(name="latitude_and_longitude",nullable=false)
    private String latitudeAndLongitude; //小区经纬度




}
