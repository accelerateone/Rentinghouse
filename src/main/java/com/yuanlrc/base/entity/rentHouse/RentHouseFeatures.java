package com.yuanlrc.base.entity.rentHouse;

import com.yuanlrc.base.annotion.ValidateEntity;
import com.yuanlrc.base.entity.admin.BaseEntity;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 租房房源特色实体类
 */
@Entity
@Table(name="ylrc_rent_house_features")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class RentHouseFeatures extends BaseEntity {

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=4,
            errorRequiredMsg="特色名称不能为空!",errorMinLengthMsg="特色名称长度需大于1!",errorMaxLengthMsg="特色名称长度不能大于4!")
    @Column(name="name",nullable=false,length=8)
    private String name;    //特色名称


}
