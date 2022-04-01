package com.yuanlrc.base.entity.houseInfo;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.houseInfoEnum.HouseDivisionWindowEnum;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 房屋分间信息
 */
@Entity
@Table(name="ylrc_house_division_info")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HouseDivisionInfo extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "housing_estate_id")
    private HousingEstate housingEstate;//小区

    @ManyToOne
    @JoinColumn(name = "house_info_id")
    private HouseInfo houseInfo;//房屋外键

    @ValidateEntity(required=true,maxLength = 20,requiredLeng = true,errorMaxLengthMsg = "分间名称长度不能超过20", errorRequiredMsg="分间名不能为空!")
    @Column(name="name",nullable=false)
    private String name;//分间名

    @ValidateEntity(required=true,maxLength = 10,requiredLeng = true,errorMaxLengthMsg = "分间面积长度不能大于10", errorRequiredMsg="分间面积不能为空!")
    @Column(name="division_area",nullable=false)
    private Double divisionArea;//分间面积

    @ValidateEntity(required=true,maxLength = 5,requiredLeng = true,errorMaxLengthMsg = "分间朝向情况长度不能超过5", errorRequiredMsg="分间朝向情况不能为空!")
    @Column(name="orientation",nullable=false)
    private String orientation;//分间朝向情况

    @Enumerated
    @Column(name="house_division")
    private HouseDivisionWindowEnum houseDivisionWindowEnum;//分间窗户
}
