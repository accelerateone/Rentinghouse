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
 * 效果图
 */
@Entity
@Table(name="ylrc_effect_picture")
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class EffectPicture extends BaseEntity {

    @ValidateEntity(required=true,errorRequiredMsg="效果图不能为空!")
    @Column(name="effect_picture_path",nullable=false)
    private String effectPicturePath;
    
}
