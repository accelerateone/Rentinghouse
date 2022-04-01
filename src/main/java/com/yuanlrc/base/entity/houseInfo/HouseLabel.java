package com.yuanlrc.base.entity.houseInfo;

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
 * 房屋标签
 */
@Entity
@Table(name="ylrc_house_label")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HouseLabel extends BaseEntity {

    @ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=4,errorRequiredMsg="房屋标签不能为空"
            ,errorMinLengthMsg="房屋标签长度不能小于1!",errorMaxLengthMsg="房屋标签长度不能大于4!")
    @Column(name = "name")
    private String name;//房屋标签
}
