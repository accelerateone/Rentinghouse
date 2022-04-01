package com.yuanlrc.base.controller.bridalChamber;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.bridalChamber.*;
import com.yuanlrc.base.service.admin.UserService;
import com.yuanlrc.base.service.bridalChamber.HouseTypeService;
import com.yuanlrc.base.service.bridalChamber.HousingCharacteristicsService;
import com.yuanlrc.base.service.bridalChamber.NewHouseInfoService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/newHouseInfo")
public class NewHouseInfoController {

    @Autowired
    private NewHouseInfoService newHouseInfoService;

    @Autowired
    private HousingCharacteristicsService housingCharacteristicsService;

    @Autowired
    private UserService userService;



    /**
     * list列表
     *
     * @param model
     * @param pageBean
     * @param newHouseInfo
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, PageBean<NewHouseInfo> pageBean, NewHouseInfo newHouseInfo) {
        model.addAttribute("name", newHouseInfo.getName());
        model.addAttribute("pageBean", newHouseInfoService.findAllByName(pageBean, newHouseInfo));
        return "admin/new_house_info/list";
    }

    /**
     * 进入保存页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("housingCharacteristicss",housingCharacteristicsService.findAll());
        model.addAttribute("decorateStates", DecorateStateEnum.values());
        model.addAttribute("openingTimes", OpeningTimeEnum.values());
        model.addAttribute("propertyTypes", PropertyTypeEnum.values());
        model.addAttribute("sellingTheStates", SellingTheStateEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        model.addAttribute("agents",userService.findByUserType(UserRoleTypeEnum.AGENT));
        return "admin/new_house_info/add";
    }

    /**
     * 进行保存
     *
     * @param newHouseInfo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(NewHouseInfo newHouseInfo) {
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(newHouseInfo);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if (newHouseInfo.getEffectPictureItems().size()<=0){
            return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_ADD_EFFECTPICTUREITEMS_ERROR);
        }
        //一切验证合法,进行保存
        if (newHouseInfoService.save(newHouseInfo) == null) {
            return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_ADD_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("housingCharacteristicss",housingCharacteristicsService.findAll());
        model.addAttribute("decorateStates", DecorateStateEnum.values());
        model.addAttribute("openingTimes", OpeningTimeEnum.values());
        model.addAttribute("propertyTypes", PropertyTypeEnum.values());
        model.addAttribute("sellingTheStates", SellingTheStateEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        model.addAttribute("agents",userService.findByUserType(UserRoleTypeEnum.AGENT));
        model.addAttribute("newHouseInfo", newHouseInfoService.find(id));
        return "admin/new_house_info/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(NewHouseInfo newHouseInfo) {
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(newHouseInfo);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }

        //一切验证合法,进行保存
        if (newHouseInfoService.save(newHouseInfo) == null){
            return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_EDIT_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> del(@RequestParam("id")Long id){
        try {
            newHouseInfoService.del(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_DELETE_ERROR);

        }
        return Result.success(true);
    }

}
