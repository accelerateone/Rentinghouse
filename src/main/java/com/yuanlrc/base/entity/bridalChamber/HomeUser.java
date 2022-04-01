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
 * 前台用户
 */
@Entity
@Table(name="ylrc_home_user")
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class HomeUser extends BaseEntity {

    @ValidateEntity(required=true,errorRequiredMsg="手机号不能为空!填写请按照正确手机格式填写")
    @Column(name="user_mobile",nullable=false,length=18,unique=true)
    private String userMobile;//手机号

    @ValidateEntity(required=true,requiredLeng=true,minLength=4,maxLength=32,
            errorRequiredMsg="密码不能为空！",errorMinLengthMsg="密码长度需大于4!",errorMaxLengthMsg="密码长度不能大于32!")
    @Column(name="password",nullable=false,length=64)
    private String password;//登录密码

    @ValidateEntity(required=true,errorRequiredMsg="邮箱不能为空！")
    @Column(name="email",nullable=false,length=32)
    private String email;


}
