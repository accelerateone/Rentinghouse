package com.yuanlrc.base.controller.bridalChamber;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.constant.SessionConstant;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.bridalChamber.HomeUser;
import com.yuanlrc.base.service.bridalChamber.HomeUserService;
import com.yuanlrc.base.util.Md5Utils;
import com.yuanlrc.base.util.SessionUtil;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/home/homeUser")
public class HomeUserController {

    @Autowired
    private HomeUserService homeUserService;

    /**
     * 登录
     * @param homeUser
     * @param code
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> login(HomeUser homeUser, @RequestParam("code") String code) {
        if (homeUser.getUserMobile() == null || "".equals(homeUser.getUserMobile())) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_NOT_EMPTY);
        }

        //正则验证输入的手机号是否合法
        String checkPhone = "^1[3|4|5|7|8]\\d{9}$";
        Pattern r = Pattern.compile(checkPhone);
        Matcher m = r.matcher(homeUser.getUserMobile());
        if (!m.matches()) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_ERROR);
        }
        if (homeUser.getPassword() == null || "".equals(homeUser.getPassword())) {
            return Result.error(CodeMsg.HOMEUSER_PASSWORD_NOT_EMPTY);
        }
        if (code == null) {
            return Result.error(CodeMsg.HOMEUSER_CODE_ERROR);
        }
        if (code.length() != 4) {
            return Result.error(CodeMsg.HOMEUSER_CODE_LENGTH_ERROR);
        }
        Object attr = SessionUtil.get(SessionConstant.HOME_USER_LOGIN_CODE);

        if (attr == null) {
            return Result.error(CodeMsg.USER_SESSION_EXPIRED);
        }

        if (!code.equalsIgnoreCase(attr.toString())) {
            return Result.error(CodeMsg.CPACHA_ERROR);
        }

        HomeUser byLoginMobile = homeUserService.findByUserMobile(homeUser.getUserMobile());

        if (byLoginMobile == null) {
            return Result.error(CodeMsg.HOMEUSER_NO_EXIST);
        }
        String md5Password = Md5Utils.hash(homeUser.getPassword());
        if (!byLoginMobile.getPassword().equals(md5Password)) {
            return Result.error(CodeMsg.HOMEUSER_PASSWORD_ERROR);
        }
        SessionUtil.set(SessionConstant.SESSION_HOME_USER_LOGIN_KEY, byLoginMobile);
        SessionUtil.set(SessionConstant.HOME_USER_LOGIN_CODE, null);
        return Result.success(true);
    }


    /**
     * 用户注册
     * @param homeUser
     * @return
     */
    @RequestMapping(value = "/regsiter", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> register(HomeUser homeUser) {
        CodeMsg codeMsg = ValidateEntityUtil.validate(homeUser);
        if (codeMsg.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(codeMsg);
        }

        //正则验证输入的手机号是否合法
        String checkPhone = "^1[3|4|5|7|8]\\d{9}$";
        Pattern r = Pattern.compile(checkPhone);
        Matcher m = r.matcher(homeUser.getUserMobile());
        if (!m.matches()) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_ERROR);
        }
        //判断手机号是否已注册
        if (homeUserService.findByUserMobile(homeUser.getUserMobile()) != null) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_EXIST);
        }
        if(homeUserService.findByEmail(homeUser.getEmail()) != null){
            return Result.error(CodeMsg.HOMEUSER_EMAIL_EXIST);
        }
        //密码进行MD5加密
        String hash = Md5Utils.hash(homeUser.getPassword());
        homeUser.setPassword(hash);
        if (homeUserService.save(homeUser) == null) {
            return Result.error(CodeMsg.HOMEUSER_ADD_ERROR);
        }
        SessionUtil.set(SessionConstant.HOME_USER_LOGIN_CODE, null);
        return Result.success(true);
    }

    /**
     * 用户找回密码
     * @param homeUser
     * @return
     */
    @RequestMapping(value = "/retrievePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> retrievePassword(HomeUser homeUser) {
        CodeMsg codeMsg = ValidateEntityUtil.validate(homeUser);
        if (codeMsg.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(codeMsg);
        }

        //正则验证输入的手机号是否合法
        String checkPhone = "^1[3|4|5|7|8]\\d{9}$";
        Pattern r = Pattern.compile(checkPhone);
        Matcher m = r.matcher(homeUser.getUserMobile());
        if (!m.matches()) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_ERROR);
        }
        //判断是否存在该手机账号
        HomeUser byUserMobile = homeUserService.findByUserMobile(homeUser.getUserMobile());
        if (byUserMobile == null) {
            return Result.error(CodeMsg.HOMEUSER_MOBILE_NAME_ERROR);
        }
        HomeUser byEmail = homeUserService.findByEmail(homeUser.getEmail());
        if (byEmail == null){
            return Result.error(CodeMsg.HOMEUSER_EMAIL_NAME_ERROR);
        }
        if (byUserMobile.getId().longValue() != byEmail.getId().longValue() ){
            return Result.error(CodeMsg.HOMEUSER_MOBILE_EMAIL_NAME_ERROR);
        }

        //密码进行MD5加密
        String hash = Md5Utils.hash(homeUser.getPassword());
        byUserMobile.setPassword(hash);

        if (homeUserService.save(byUserMobile) == null) {
            return Result.error(CodeMsg.HOMEUSER_ADD_ERROR);
        }
        SessionUtil.set(SessionConstant.HOME_USER_LOGIN_CODE, null);
        return Result.success(true);
    }



    /**
     * 退出
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout(){
        HomeUser homeUser = SessionUtil.getHomeUser();
        if(homeUser != null){
            SessionUtil.set(SessionConstant.SESSION_HOME_USER_LOGIN_KEY, null);
        }
        return "redirect:/home/index/bridalChamberIndex";
    }



}
