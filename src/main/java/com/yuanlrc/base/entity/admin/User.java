package com.yuanlrc.base.entity.admin;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yuanlrc.base.annotion.ValidateEntity;

/**
 * 后台用户实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ylrc_user")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity{


	private static final long serialVersionUID = 1L;
	
	private static final int USER_SEX_MAN = 1;//性别男
	
	private static final int USER_SEX_WOMAN = 2;//性别女
	
	private static final int USER_SEX_UNKONW = 0;//性别未知
	
	public static final int ADMIN_USER_STATUS_ENABLE = 1;//用户状态正常可用
	public static final int ADMIN_USER_STATUS_UNABLE = 0;//用户状态不可用



	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;//用户所属角色
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=2,maxLength=18,errorRequiredMsg="姓名不能为空!",
			errorMinLengthMsg="姓名长度需大于2!",errorMaxLengthMsg="姓名长度不能大于18!")
	@Column(name="username",nullable=false,length=18,unique=true)
	private String username;//用户名
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=4,maxLength=32,
			errorRequiredMsg="密码不能为空！",errorMinLengthMsg="密码长度需大于4!",errorMaxLengthMsg="密码长度不能大于32!")
	@Column(name="password",nullable=false,length=32)
	private String password;//登录密码
	
	@ValidateEntity(required=false)
	@Column(name="status",length=1)
	private int status = ADMIN_USER_STATUS_ENABLE;//用户状态,默认可用

	@ValidateEntity(required=true,errorRequiredMsg="头像不能为空!")
	@Column(name="head_pic",length=128)
	private String headPic;//用户头像
	
	@ValidateEntity(required=false)
	@Column(name="sex",length=1)
	private int sex = USER_SEX_UNKONW;//用户性别

	@ValidateEntity(required=true,requiredLeng=true,minLength=11,maxLength=11,errorRequiredMsg="手机号不能为空!",
			errorMinLengthMsg="手机号长度只能为11位!",errorMaxLengthMsg="手机号长度只能为11位!")
	@Column(name="mobile",length=12)
	private String mobile;//用户手机号
	
	@ValidateEntity(required=false)
	@Column(name="email",length=32)
	private String email;//用户邮箱

	@Column(name="label",length=128)
	private String label; //标签

	@Column(name="years_of_service",length=128)
	private Integer yearsOfService;  //服务平台年限


	@Column(name="certificate",length=128)
	private String certificate; //证件编码

	@Enumerated
	@Column(name = "user_type")
	private UserRoleTypeEnum userType; //用户类型

	public UserRoleTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserRoleTypeEnum userType) {
		this.userType = userType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(Integer yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"role=" + role +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", headPic='" + headPic + '\'' +
				", sex=" + sex +
				", mobile='" + mobile + '\'' +
				", email='" + email + '\'' +
				", label='" + label + '\'' +
				", yearsOfService=" + yearsOfService +
				", certificate='" + certificate + '\'' +
				", userType=" + userType +
				'}';
	}
}
