package com.yuanlrc.base.controller.houseInfo;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseLabel;
import com.yuanlrc.base.entity.houseInfoEnum.*;
import com.yuanlrc.base.service.admin.HousingEstateService;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.admin.UserService;
import com.yuanlrc.base.service.houseInfo.HouseInfoService;
import com.yuanlrc.base.service.houseInfo.HouseLabelService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@RequestMapping("/admin/houseInfo")
@Controller
public class HouseInfoController {
    @Autowired
    private HouseInfoService houseInfoService;
    @Autowired
    private HousingEstateService housingEstateService;
    @Autowired
    private HouseLabelService labelService;
    @Autowired
    private OperaterLogService operaterLogService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model, String name, PageBean<HouseInfo> pageBean) {
        model.addAttribute("title", "二手房屋信息列表");
        model.addAttribute("name", name);
        model.addAttribute("pageBean", houseInfoService.findListByName(pageBean,name));
        return "admin/house_info/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("housingEstate", housingEstateService.findAll());
        model.addAttribute("houseLabels", labelService.findAll());
        model.addAttribute("houseType", HouseTypeEnum.values());
        model.addAttribute("houseOrientation", HouseOrientationEnum.values());
        model.addAttribute("houseRenovation", HouseRenovationEnum.values());
        model.addAttribute("housePurpose", HousePurposeEnum.values());
        model.addAttribute("houseElevator", HouseElevatorEnum.values());
        model.addAttribute("houseOwnership", HouseOwnershipEnum.values());
        model.addAttribute("houseArchitectureType", HouseArchitectureTypeEnum.values());
        model.addAttribute("houseSales", HouseSalesEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        return "admin/house_info/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HouseInfo houseInfo) {
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseInfo);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(validate);
        }
        houseInfo.setProvince(houseInfo.getHousingEstate().getProvince());
        houseInfo.setCity(houseInfo.getHousingEstate().getCity());
        houseInfo.setDistrict(houseInfo.getHousingEstate().getDistrict());
        houseInfo.setUnitPrice((houseInfo.getSpecificPrice() * 10000 / houseInfo.getArea()));
        if (houseInfoService.save(houseInfo) == null) {
            return Result.error(CodeMsg.ADMIN_HOUSE_INFO_ADD_FAIL);
        }
        operaterLogService.add("添加房屋信息,房间号:" + houseInfo.getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(name = "id", required = true) Long id) {
        ArrayList<String> arrayList = new ArrayList<>();
        HouseInfo houseInfo = houseInfoService.find(id);
        String detailsPics = houseInfo.getDetailsPics();
        String[] split = detailsPics.split(",");
        for (int i = 0; i < split.length; i++) {
            arrayList.add(split[i]);
        }
        model.addAttribute("arrayList", arrayList);
        model.addAttribute("houseInfo", houseInfo);
        model.addAttribute("housingEstate", housingEstateService.findAll());
        model.addAttribute("houseLabels", labelService.findAll());
        model.addAttribute("houseType", HouseTypeEnum.values());
        model.addAttribute("houseOrientation", HouseOrientationEnum.values());
        model.addAttribute("houseRenovation", HouseRenovationEnum.values());
        model.addAttribute("housePurpose", HousePurposeEnum.values());
        model.addAttribute("houseElevator", HouseElevatorEnum.values());
        model.addAttribute("houseOwnership", HouseOwnershipEnum.values());
        model.addAttribute("houseArchitectureType", HouseArchitectureTypeEnum.values());
        model.addAttribute("houseSales", HouseSalesEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        return "admin/house_info/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HouseInfo houseInfo) {
        houseInfo.setUnitPrice((houseInfo.getSpecificPrice() * 10000 / houseInfo.getArea()));
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseInfo);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(validate);
        }
        HouseInfo findById = houseInfoService.find(houseInfo.getId());
        BeanUtils.copyProperties(houseInfo, findById, "id", "createTime", "updateTime", "province", "city", "district");
        if (houseInfoService.save(findById) == null) {
            return Result.error(CodeMsg.ADMIN_HOUSE_INFO_EDIT_FAIL);
        }
        operaterLogService.add("编辑房屋信息,房间号:" + houseInfo.getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id", required = true) Long id) {
        try {
            houseInfoService.delete(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.ADMIN_HOUSE_INFO_DELETE_FAIL);
        }
        operaterLogService.add("删除二手房信息，二手房id：" + id);
        return Result.success(true);
    }
}
