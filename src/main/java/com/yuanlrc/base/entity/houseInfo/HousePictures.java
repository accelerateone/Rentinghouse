package com.yuanlrc.base.entity.houseInfo;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 房屋图片
 */
@Entity
@Table(name="ylrc_house_pictures")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HousePictures extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "housing_estate_id")
    @ValidateEntity(required=true,errorRequiredMsg="小区不能为空")
    private HousingEstate housingEstate;//小区

    @ManyToOne
    @JoinColumn(name = "house_info_id")
    @ValidateEntity(required=true,errorRequiredMsg="房间信息不能为空")
    private HouseInfo houseInfo;//房屋

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=10,errorRequiredMsg="房屋图片名称不能为空"
            ,errorMinLengthMsg="房屋图片名称长度不能小于1!",errorMaxLengthMsg="房屋图片名称长度不能大于10!")
    @Column(name = "name")
    private String name;//房屋图片名称

    @ValidateEntity(required=true,errorRequiredMsg="房屋图片不能为空")
    @Column(name="picture",length=128)
    private String picture;//图片地址
}
