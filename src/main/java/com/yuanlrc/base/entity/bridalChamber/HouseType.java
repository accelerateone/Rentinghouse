package com.yuanlrc.base.entity.bridalChamber;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.admin.Role;
import com.yuanlrc.base.entity.admin.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 户型
 */
@Entity
@Table(name="ylrc_house_type")
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class HouseType extends BaseEntity {



    @ValidateEntity(required=true,errorRequiredMsg="户型图不能为空!")
    @Column(name="floor_plan",nullable=false)
    private String floorPlan;    //户型图路径

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=18,errorRequiredMsg="户型名不能为空!",errorMinLengthMsg="户型名长度需大于1!",errorMaxLengthMsg="户型名长度不能大于10!")
    @Column(name="name",nullable=false,length=10)
    private String name; //户型名

    @ValidateEntity(required=true,errorRequiredMsg="户型面积不能为空!")
    @Column(name="door_area",nullable=false)
    private BigDecimal doorArea;    //户型面积

    @ValidateEntity(required=true,errorRequiredMsg="楼盘不能为空!")
    @ManyToOne
    @JoinColumn(name="new_house_info")
    private NewHouseInfo newHouseInfo;//户型所属楼盘

}
