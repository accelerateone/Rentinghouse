package com.yuanlrc.base.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 系统运行时的常量
 *
 * @author Administrator
 */
public class RuntimeConstant {

	//后台登录拦截器无需拦截的url
	public static List<String> loginExcludePathPatterns = Arrays.asList(
			"/system/login",
			"/system/admin/system/login",
			"/system/auth_order",
			"/admin/css/**",
			"/admin/fonts/**",
			"/photo/view",
			"/admin/js/**",
			"/admin/images/**",
			"/home/layui/**",
			"/error",
			"/home/**",
			"/cpacha/generate_cpacha",
			"/websocket/**"
	);
	//后台权限拦截器无需拦截的url
	public static List<String> authorityExcludePathPatterns = Arrays.asList(
			"/system/login",
			"/system/admin/system/login",
			"/system/auth_order",
			"/system/index",
			"/system/no_right",
			"/admin/css/**",
			"/admin/fonts/**",
			"/admin/js/**",
			"/admin/images/**",
			"/home/layui/**",
			"/error",
			"/cpacha/generate_cpacha",
			"/system/logout",
			"/system/update_userinfo",
			"/system/update_pwd",
			"/photo/view",
			"/home/**",
			"/admin/bootstrap-fileinput/**",
			"/admin/housingEstate/fileAdd",
			"/admin/houseInspectionRecord/add/house",
			"/admin/bootstrap-datetimepicker/**",
			"/admin/bootstrap-fileinput/**",
			"/admin/bootstrap-select/**",
			"/admin/Distpicker/**",
			"/admin/bootstrap-datepicker/**",
			"/admin/houseInspectionRecord/add/house",
			"/home/rentHouse/**",
			"/home/rent_house/**",
			"/admin/house_inspection_record/add/house",
			"/admin/rentHouse/add/housingEstate",
			"/websocket/**"
	);

    //前台权限拦截器无需拦截的url
    public static List<String> authorityHomeExcludePathPatterns = Arrays.asList(
    		"/home/homeUser/**",
            "/system/**",
            "/admin/**",
            "/error",
            "/cpacha/generate_cpacha",
            "/photo/view",
            "/upload/home_upload_photo",
            "/home/css/**",
            "/home/cssimg/**",
            "/home/images/**",
            "/home/js/**",
            "/home/layui/**",
            "/home/index/**",
            "/home/deskUser/**",
            "/home/bridalChamber/**",
            "/home/housing_estate/**",
            "/home/housingEstate/**",
            "/home/bridalChamber/picture/**",
			"/home/houseInfo/css/**",
			"/home/houseInfo/images/**",
			"/home/houseInfo/js/**",
			"/home/houseInfo/picture/**",
			"/home/rentHouse/**",
			"/home/rent_house/**",
			"/home/houseInfo/picture/**",
			"/home/homeNewHouseInfo/**",
			"/websocket/**",
			"/home/layui/**",
			"/home/rent_house_details/**",
			"/home/homeNewHouseInfo/**"
    );
}
