package com.yuanlrc.base.entity.bridalChamber;

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
 * 特色
 */
@Entity
@Table(name="ylrc_housing_characteristics")
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class HousingCharacteristics extends BaseEntity {

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=4,errorRequiredMsg="特色名称不能为空!",errorMinLengthMsg="特色名称长度需大于1!",errorMaxLengthMsg="特色名称长度不能大于4!")
    @Column(name="name",nullable=false,length=10)
    private String name;    //特色名称

}
