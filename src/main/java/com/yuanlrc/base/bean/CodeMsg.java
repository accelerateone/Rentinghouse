package com.yuanlrc.base.bean;
/**
 * 错误码统一处理类，所有的错误码统一定义在这里
 * @author Administrator
 *
 */
public class CodeMsg {

	private int code;//错误码
	
	private String msg;//错误信息
	
	/**
	 * 构造函数私有化即单例模式
	 * @param code
	 * @param msg
	 */
	private CodeMsg(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//通用错误码定义
	//处理成功消息码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	//非法数据错误码
	public static CodeMsg DATA_ERROR = new CodeMsg(-1, "非法数据！");
	public static CodeMsg CPACHA_EMPTY = new CodeMsg(-2, "验证码不能为空！");
	public static CodeMsg VALIDATE_ENTITY_ERROR = new CodeMsg(-3, "");
	public static CodeMsg SESSION_EXPIRED = new CodeMsg(-4, "会话已失效，请刷新页面重试！");
	public static CodeMsg CPACHA_ERROR = new CodeMsg(-5, "验证码错误！");
	public static CodeMsg USER_SESSION_EXPIRED = new CodeMsg(-6, "还未登录或会话失效，请重新登录！");
	public static CodeMsg UPLOAD_PHOTO_SUFFIX_ERROR = new CodeMsg(-7, "图片格式不正确！");
	public static CodeMsg UPLOAD_PHOTO_ERROR = new CodeMsg(-8, "图片上传错误！");
	public static CodeMsg UPLOAD_PHOTO_ERROR1 = new CodeMsg(-9, "图片上传错误！图片名中不能包含逗号");
	public static CodeMsg ORDER_SN_ERROR = new CodeMsg(-12, "订单编号错误！");
	public static CodeMsg PHONE_ERROR = new CodeMsg(-13, "手机号错误！");
	public static CodeMsg ORDER_AUTH_ERROR = new CodeMsg(-14, "\u8ba2\u5355\u9a8c\u8bc1\u5931\u8d25\uff0c\u8ba2\u5355\u7f16\u53f7\u6216\u624b\u673a\u53f7\u8f93\u5165\u6709\u8bef\u6216\u8005\u53ef\u80fd\u4f60\u8d2d\u4e70\u7684\u662f\u76d7\u7248\uff0c\u8bf7\u8054\u7cfb\u3010\u733f\u6765\u5165\u6b64\u3011\u5ba2\u670d\uff01");
	
	//后台管理类错误码
	//用户管理类错误
	public static CodeMsg ADMIN_USERNAME_EMPTY = new CodeMsg(-2000, "用户名不能为空！");
	public static CodeMsg ADMIN_PASSWORD_EMPTY = new CodeMsg(-2001, "密码不能为空！");
	public static CodeMsg ADMIN_NO_RIGHT = new CodeMsg(-2002, "您所属的角色没有该权限！");
	
	//登录类错误码
	public static CodeMsg ADMIN_USERNAME_NO_EXIST = new CodeMsg(-3000, "该用户名不存在！");
	public static CodeMsg ADMIN_PASSWORD_ERROR = new CodeMsg(-3001, "密码错误！");
	public static CodeMsg ADMIN_USER_UNABLE = new CodeMsg(-3002, "该用户已被冻结，请联系管理员！");
	public static CodeMsg ADMIN_USER_ROLE_UNABLE = new CodeMsg(-3003, "该用户所属角色状态不可用，请联系管理员！");
	public static CodeMsg ADMIN_USER_ROLE_AUTHORITES_EMPTY = new CodeMsg(-3004, "该用户所属角色无可用权限，请联系管理员！");
	
	//后台菜单管理类错误码
	public static CodeMsg ADMIN_MENU_ADD_ERROR = new CodeMsg(-4000, "菜单添加失败，请联系管理员！");
	public static CodeMsg ADMIN_MENU_EDIT_ERROR = new CodeMsg(-4001, "菜单编辑失败，请联系管理员！");
	public static CodeMsg ADMIN_MENU_ID_EMPTY = new CodeMsg(-4002, "菜单ID不能为空！");
	public static CodeMsg ADMIN_MENU_ID_ERROR = new CodeMsg(-4003, "菜单ID错误！");
	public static CodeMsg ADMIN_MENU_DELETE_ERROR = new CodeMsg(-4004, "改菜单下有子菜单，不允许删除！");
	//后台角色管理类错误码
	public static CodeMsg ADMIN_ROLE_ADD_ERROR = new CodeMsg(-5000, "角色添加失败，请联系管理员！");
	public static CodeMsg ADMIN_ROLE_NO_EXIST = new CodeMsg(-5001, "该角色不存在！");
	public static CodeMsg ADMIN_ROLE_EDIT_ERROR = new CodeMsg(-5002, "角色编辑失败，请联系管理员！");
	public static CodeMsg ADMIN_ROLE_DELETE_ERROR = new CodeMsg(-5003, "该角色下存在用户信息，不可删除！");
	//后台管理员管理类错误码
	public static CodeMsg ADMIN_USER_ROLE_EMPTY = new CodeMsg(-6000, "请选择管理员所属角色！");
	public static CodeMsg ADMIN_USERNAME_EXIST = new CodeMsg(-6001, "该管理员名已存在，请换一个试试！");
	public static CodeMsg ADMIN_USE_ADD_ERROR = new CodeMsg(-6002, "管理员添加失败，请联系超级管理员！");
	public static CodeMsg ADMIN_USE_NO_EXIST = new CodeMsg(-6003, "管理员不存在！");
	public static CodeMsg ADMIN_USE_EDIT_ERROR = new CodeMsg(-6004, "管理员编辑失败，请联系超级管理员！");
	public static CodeMsg ADMIN_USE_DELETE_ERROR = new CodeMsg(-6005, "该管理员存在关联数据，不允许删除！");
	//后台顾问管理类错误码
	public static CodeMsg CONSULTANT_USER_ROLE_EMPTY = new CodeMsg(-27000, "请选择顾问所属角色！");
	public static CodeMsg CONSULTANT_USERNAME_EXIST = new CodeMsg(-27001, "该登录名称已存在，请换一个试试！");
	public static CodeMsg CONSULTANT_USE_ADD_ERROR = new CodeMsg(-27002, "顾问添加失败，请联系管理员！");
	public static CodeMsg CONSULTANT_USE_NO_EXIST = new CodeMsg(-27003, "顾问不存在！");
	public static CodeMsg CONSULTANT_USE_EDIT_ERROR = new CodeMsg(-27004, "顾问编辑失败，请联系管理员！");
	public static CodeMsg CONSULTANT_USE_DELETE_ERROR = new CodeMsg(-27005, "该顾问存在关联数据，不允许删除！");

	//后台经纪人管理类错误码
	public static CodeMsg AGENT_USER_ROLE_EMPTY = new CodeMsg(-28000, "请选择经纪人所属角色！");
	public static CodeMsg AGENT_USERNAME_EXIST = new CodeMsg(-28001, "该登录名已存在，请换一个试试！");
	public static CodeMsg AGENT_USE_ADD_ERROR = new CodeMsg(-28002, "经纪人添加失败，请联系管理员！");
	public static CodeMsg AGENT_USE_NO_EXIST = new CodeMsg(-28003, "经纪人不存在！");
	public static CodeMsg AGENT_USE_EDIT_ERROR = new CodeMsg(-28004, "经纪人编辑失败，请联系管理员！");
	public static CodeMsg AGENT_USE_DELETE_ERROR = new CodeMsg(-28005, "该经纪人存在关联数据，不允许删除！");

	public static CodeMsg AGENT_USER_CERTIFICATE_EMPTY = new CodeMsg(-29001, "证件编码不能为空！");
	public static CodeMsg AGENT_USER_CITY_EMPTY = new CodeMsg(-29002, "所在市不能为空！");
	public static CodeMsg AGENT_USER_DISTRICT_EMPTY = new CodeMsg(-29003, "所在区不能为空！");
	public static CodeMsg AGENT_USER_TOWN_EMPTY = new CodeMsg(-29004, "所在镇不能为空！");
	public static CodeMsg AGENT_USER_YEARSOFSERVICE_EMPTY = new CodeMsg(-29005, "服务年限不能为空！");
	public static CodeMsg AGENT_USER_LATITUDEANDLONGITUDE_EMPTY = new CodeMsg(-29006, "所在门店经纬度不能为空！");
	public static CodeMsg AGENT_USER_STORES_EMPTY = new CodeMsg(-29007, "所在门店不能为空！");

	//后台租房特色管理类错误码
	public static CodeMsg RENT_HOUSE_FEATURES_NAME_EXIST = new CodeMsg(-29101, "该租房特色名已存在，请换一个试试！");
	public static CodeMsg RENT_HOUSE_FEATURES_ADD_ERROR = new CodeMsg(-29102, "租房特色添加失败，请联系管理员！");
	public static CodeMsg RENT_HOUSE_FEATURES_NO_EXIST = new CodeMsg(-29103, "租房特色不存在！");
	public static CodeMsg RENT_HOUSE_FEATURES_EDIT_ERROR = new CodeMsg(-29104, "租房特色编辑失败，请联系管理员！");
	public static CodeMsg RENT_HOUSE_FEATURES_DELETE_ERROR = new CodeMsg(-29105, "该租房特色存在关联数据，不允许删除！");


	//后台小区管理类错误码
	public static CodeMsg HOUSING_ESTATE_DELETE_ERROR = new CodeMsg(-29201, "该小区存在关联数据，不允许删除！");
	public static CodeMsg HOUSING_ESTATE_NAME_EXIST = new CodeMsg(-29202, "该小区名已存在，请换一个试试！");
	public static CodeMsg HOUSING_ESTATE_ADD_ERROR = new CodeMsg(-29203, "小区添加失败，请联系管理员！");
	
	//后台用户修改密码类错误码
	public static CodeMsg ADMIN_USER_UPDATE_PWD_ERROR = new CodeMsg(-7000, "旧密码错误！");
	public static CodeMsg ADMIN_USER_UPDATE_PWD_EMPTY = new CodeMsg(-7001, "新密码不能为空！");
	
	//后台用户修改密码类错误码
	public static CodeMsg ADMIN_DATABASE_BACKUP_NO_EXIST = new CodeMsg(-8000, "备份记录不存在！");

	//后台户型管理类错误码
	public static CodeMsg ADMIN_HOUSETYPE_ADD_ERROR = new CodeMsg(-999001, "户型添加失败,请联系管理员!");
	public static CodeMsg ADMIN_HOUSETYPE_EDIT_ERROR = new CodeMsg(-999002, "户型编辑失败,请联系管理员!");
	public static CodeMsg ADMIN_HOUSETYPE_DELETE_ERROR = new CodeMsg(-999003, "该户型存在关联数据，不允许删除！");

	//后台楼盘特色管理类错误码
	public static CodeMsg ADMIN_HOUSINGCHARACTERISTICS_ADD_ERROR = new CodeMsg(-999004, "楼盘特色添加失败,请联系管理员!");
	public static CodeMsg ADMIN_HOUSINGCHARACTERISTICS_EDIT_ERROR = new CodeMsg(-999005, "楼盘特色编辑失败,请联系管理员!");
	public static CodeMsg ADMIN_HOUSINGCHARACTERISTICS_DELETE_ERROR = new CodeMsg(-999006, "该楼盘特色存在关联数据，不允许删除！");

	//后台楼盘管理类错误码
	public static CodeMsg ADMIN_NEWHOUSEINFO_ADD_ERROR = new CodeMsg(-999004, "楼盘添加失败,请联系管理员!");
	public static CodeMsg ADMIN_NEWHOUSEINFO_ADD_EFFECTPICTUREITEMS_ERROR = new CodeMsg(-999005, "请上传详情图!");
	public static CodeMsg ADMIN_NEWHOUSEINFO_EDIT_ERROR = new CodeMsg(-999006, "楼盘编辑失败,请联系管理员!");
	public static CodeMsg ADMIN_NEWHOUSEINFO_DELETE_ERROR = new CodeMsg(-999007, "该楼盘存在关联数据，不允许删除！");
	public static CodeMsg ADMIN_NEWHOUSEINFO_ADD_EDIT_ERROR = new CodeMsg(-999006, "楼盘保存/编辑失败,请联系管理员!");

	//后台租房管理类错误码
	public static CodeMsg RENT_HOUSE_NAME_EXIST = new CodeMsg(-55001, "该租房名已存在，请换一个试试！");
	public static CodeMsg RENT_HOUSE_NO_EXIST = new CodeMsg(-55002, "租房不存在！");
	public static CodeMsg RENT_HOUSE_ADD_ERROR = new CodeMsg(-55003, "租房添加失败，请联系管理员！");
	public static CodeMsg RENT_HOUSE_EDIT_ERROR = new CodeMsg(-55004, "租房编辑失败，请联系管理员！");
	public static CodeMsg RENT_HOUSE_DELETE_ERROR = new CodeMsg(-55005, "该租房存在关联数据，不允许删除！");


	/*-----------------------------------------------------------------------------------------------------------------*/
	/**
	 * @author hz
	 */
	//后台房屋标签类错误码
	public static CodeMsg ADMIN_HOUSE_LABEL_ADD_FAIL = new CodeMsg(-30001, "添加房屋标签失败！");
	public static CodeMsg ADMIN_HOUSE_LABEL_EDIT_FAIL = new CodeMsg(-30002, "编辑房屋标签失败！");
	public static CodeMsg ADMIN_HOUSE_LABEL_DELETE_FAIL = new CodeMsg(-30003, "该数据有关联数据,不能删除！");
	public static CodeMsg ADMIN_HOUSE_LABEL_ADD_ERROR = new CodeMsg(-30004, "房屋标签名不能重复！");

	//后台房屋分间信息类错误码
	public static CodeMsg ADMIN_HOUSE_DIVISION_ADD_FAIL = new CodeMsg(-30004, "添加房屋分间信息失败！");
	public static CodeMsg ADMIN_HOUSE_DIVISION_ADD_ERROR = new CodeMsg(-30005, "房屋信息不能为空！");
	public static CodeMsg ADMIN_HOUSE_DIVISION_ADD_ERROR_2 = new CodeMsg(-30006, "窗户情况不能为空！");
	public static CodeMsg ADMIN_HOUSE_DIVISION_EDIT_FAIL = new CodeMsg(-30007, "编辑房屋分间信息失败！");
	public static CodeMsg ADMIN_HOUSE_DIVISION_DELETE_FAIL = new CodeMsg(-30008, "删除房屋分间信息失败！");

	//后台带看记录类错误码
	public static CodeMsg ADMIN_HOUSE_RECORD_ADD_FAIL = new CodeMsg(-30011, "添加带看记录失败！");
	public static CodeMsg ADMIN_HOUSE_RECORD_ADD_ERROR = new CodeMsg(-30012, "房屋信息不能为空！");
	public static CodeMsg ADMIN_HOUSE_RECORD_ADD_ERROR_2 = new CodeMsg(-30013, "小区信息不能为空！");
	public static CodeMsg ADMIN_HOUSE_RECORD_ADD_ERROR_3 = new CodeMsg(-30016, "窗户信息不能为空！");
	public static CodeMsg ADMIN_HOUSE_RECORD_EDIT_FAIL = new CodeMsg(-30014, "编辑带看记录失败！");
	public static CodeMsg ADMIN_HOUSE_RECORD_DELETE_FAIL = new CodeMsg(-30015, "该数据有关联数据,不能删除！");

	//前台用户登录注册修改密码错误码
	public static CodeMsg HOMEUSER_MOBILE_ERROR = new CodeMsg(-60008,"手机号格式错误！");
	public static CodeMsg HOMEUSER_CODE_ERROR = new CodeMsg(-60008,"验证码不能为空！");
	public static CodeMsg HOMEUSER_CODE_LENGTH_ERROR = new CodeMsg(-60008,"验证码长度错误！");
	public static CodeMsg HOMEUSER_MOBILE_EXIST = new CodeMsg(-60008,"该手机号已存在！");
	public static CodeMsg HOMEUSER_EMAIL_EXIST = new CodeMsg(-60008,"该邮箱已存在！");
	public static CodeMsg HOMEUSER_ADD_ERROR = new CodeMsg(-60008, "注册失败！请稍后重试");
	public static CodeMsg HOMEUSER_MOBILE_NAME_ERROR = new CodeMsg(-60008,"手机号输入错误！");
	public static CodeMsg HOMEUSER_EMAIL_NAME_ERROR = new CodeMsg(-60008,"邮箱输入错误！");
	public static CodeMsg HOMEUSER_MOBILE_EMAIL_NAME_ERROR = new CodeMsg(-60008,"该账号无法找回请再注册一个！");
	public static CodeMsg HOMEUSER_NO_EXIST = new CodeMsg(-60008,"登录手机号不存在！");
	public static CodeMsg HOMEUSER_PASSWORD_ERROR = new CodeMsg(-60008,"密码错误！");
	public static CodeMsg HOMEUSER_MOBILE_NOT_EMPTY = new CodeMsg(-60008,"手机号不能为空！");
	public static CodeMsg HOMEUSER_PASSWORD_NOT_EMPTY = new CodeMsg(-60008,"密码不能为空！");


	//后台房屋信息管理类错误码
	public static CodeMsg ADMIN_HOUSE_INFO_ADD_FAIL = new CodeMsg(-30021, "添加房屋信息失败！");
	public static CodeMsg ADMIN_HOUSE_INFO_EDIT_FAIL = new CodeMsg(-30022, "编辑房屋信息失败！");
	public static CodeMsg ADMIN_HOUSE_INFO_DELETE_FAIL = new CodeMsg(-30023, "该数据有关联数据,不能删除!");

	//后台房屋照片管理类错误码
	public static CodeMsg ADMIN_HOUSE_PICTURE_ADD_FAIL = new CodeMsg(-30031, "添加房屋照片失败！");
	public static CodeMsg ADMIN_HOUSE_PICTURE_EDIT_FAIL = new CodeMsg(-30032, "编辑房屋照片失败！");
	public static CodeMsg ADMIN_HOUSE_PICTURE_DELETE_FAIL = new CodeMsg(-30033, "该数据有关联数据,不能删除！");


}
