package com.yuanlrc.base.controller.houseInfo;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.houseInfo.HouseDivisionInfo;
import com.yuanlrc.base.entity.houseInfoEnum.HouseDivisionWindowEnum;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.houseInfo.HouseDivisionInfoService;
import com.yuanlrc.base.service.houseInfo.HouseInfoService;
import com.yuanlrc.base.service.admin.HousingEstateService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 房屋分间信息控制器
 */
@RequestMapping("/admin/houseDivisionInfo")
@Controller
public class HouseDivisionInfoController {
    @Autowired
    private HouseDivisionInfoService houseDivisionInfoService;
    @Autowired
    private HouseInfoService houseInfoService;
    @Autowired
    private OperaterLogService operaterLogService;
    @Autowired
    private HousingEstateService housingEstateService;


    @RequestMapping("/list")
    public String list(Model model, PageBean<HouseDivisionInfo> pageBean,HouseDivisionInfo houseDivisionInfo,String houseNumber){
        model.addAttribute("title","房屋分间信息列表");
        model.addAttribute("houseNumber",houseDivisionInfo.getHouseInfo() == null?"":houseDivisionInfo.getHouseInfo().getHouseNumber());
        model.addAttribute("pageBean",houseDivisionInfoService.findList(houseDivisionInfo,pageBean));
        return "admin/house_division_info/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("housingEstate",housingEstateService.findAll());
        model.addAttribute("houseDivisionWindowEnums", HouseDivisionWindowEnum.values());
        return "admin/house_division_info/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HouseDivisionInfo houseDivisionInfo){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseDivisionInfo);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if (houseDivisionInfo.getHouseDivisionWindowEnum().getCode()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_ERROR_3);
        }
        if (houseDivisionInfo.getHousingEstate()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_ERROR_2);
        }
        if (houseDivisionInfo.getHouseInfo()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_ADD_ERROR);
        }
        if (houseDivisionInfo.getHouseDivisionWindowEnum()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_ADD_ERROR_2);
        }
        if (houseDivisionInfoService.save(houseDivisionInfo)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_ADD_FAIL);
        }
        operaterLogService.add("添加房屋分间信息，房间号：" + houseDivisionInfo.getHouseInfo().getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model,@RequestParam(name = "id",required = true) Long id){
        HouseDivisionInfo houseDivisionInfo = houseDivisionInfoService.find(id);
        model.addAttribute("houseDivisionInfo",houseDivisionInfo);
        model.addAttribute("housingEstate",housingEstateService.findAll());
        model.addAttribute("houseInfo",houseInfoService.findByHousingEstateId(houseDivisionInfo.getHousingEstate().getId()));
        model.addAttribute("houseDivisionWindowEnums", HouseDivisionWindowEnum.values());
        return "admin/house_division_info/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HouseDivisionInfo houseDivisionInfo){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseDivisionInfo);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if (houseDivisionInfo.getHousingEstate()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_ERROR_2);
        }
        if (houseDivisionInfo.getHouseInfo()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_ADD_ERROR);
        }
        if (houseDivisionInfo.getHouseDivisionWindowEnum()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_ADD_ERROR_2);
        }
        HouseDivisionInfo findById = houseDivisionInfoService.find(houseDivisionInfo.getId());
        BeanUtils.copyProperties(houseDivisionInfo,findById,"id","createTime","updateTime");
        if (houseDivisionInfoService.save(findById)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_EDIT_FAIL);
        }
        operaterLogService.add("编辑房屋分间信息，房间号：" + houseDivisionInfo.getHouseInfo().getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id",required = true) Long id){
        try {
            houseDivisionInfoService.delete(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_HOUSE_DIVISION_DELETE_FAIL);
        }
        operaterLogService.add("删除房屋分间信息，分间信息id：" + id);
        return Result.success(true);
    }
}
