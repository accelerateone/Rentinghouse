package com.yuanlrc.base.controller.admin;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseFloorEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseOrientationEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import com.yuanlrc.base.entity.rentHouse.*;
import com.yuanlrc.base.service.admin.*;
import com.yuanlrc.base.util.SessionUtil;
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
import java.util.List;


/**
 * 租房后台控制层
 *
 * @author wangzihan
 * @date : 2021/1/9 16:34
 */
@RequestMapping("/admin/rentHouse/")
@Controller
public class RentHouseController {

    @Autowired
    private RentHouseService rentHouseService;
    @Autowired
    private RentHouseFeaturesService rentHouseFeaturesService;
    @Autowired
    private HousingEstateService housingEstateService;
    @Autowired
    private OperaterLogService operaterLogService;
    @Autowired
    private UserService userService;


    /**
     * 租房列表页面
     *
     * @param model
     * @param rentHouse
     * @param pageBean
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model, RentHouse rentHouse, PageBean<RentHouse> pageBean) {
        model.addAttribute("title", "租房列表");
        model.addAttribute("name", rentHouse.getName());
        model.addAttribute("pageBean", rentHouseService.findList(rentHouse, pageBean,2));
        return "admin/rent_house/list";
    }

    /**
     * 新增租房页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("rentHouseFeaturesList", rentHouseFeaturesService.findAll());
        model.addAttribute("houseFloorEnums", HouseFloorEnum.values());
        model.addAttribute("houseWayEnums", RentHouseWayEnum.values());
        model.addAttribute("houseLeaseEnums", RentHouseLeaseEnum.values());
        model.addAttribute("houseTypeEnums", RentHouseTypeEnum.values());
        model.addAttribute("HouseOrientationEnums", HouseOrientationEnum.values());
        model.addAttribute("houseElevatorEnums", RentHouseElevatorEnum.values());
        model.addAttribute("houseFeaturesEnums", RentHouseFeaturesEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        return "admin/rent_house/add";
    }

    /**
     * 通过区找小区二级联动
     * @param district
     * @return
     */
    @RequestMapping(value = "/add/housingEstate", method = RequestMethod.POST)
    @ResponseBody
    public List<HousingEstate> select(@RequestParam(value = "district", required = true) String district) {
        List<HousingEstate> housingEstateList = housingEstateService.findByDistrictLike(district);
        return housingEstateList;
    }

    /**
     * 租房添加表单提交处理
     *
     * @param rentHouse
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(RentHouse rentHouse) {
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(rentHouse);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(validate);
        }
        User loginedUser = SessionUtil.getLoginedUser();
        rentHouse.setUser(loginedUser);
        //判断租房名是否存在
        if (rentHouseService.isExistName(rentHouse.getName(), 0L)) {
            return Result.error(CodeMsg.RENT_HOUSE_NAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库新增
        if (rentHouseService.save(rentHouse) == null) {
            return Result.error(CodeMsg.RENT_HOUSE_ADD_ERROR);
        }
        operaterLogService.add("添加租房，租房名：" + rentHouse.getName());
        return Result.success(true);
    }

    /**
     * 租房编辑页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(name = "id", required = true) Long id) {
        ArrayList<String> arrayList = new ArrayList<>();
        RentHouse rentHouse = rentHouseService.find(id);
        String detailsPics = rentHouse.getDetailsPics();
        String[] split = detailsPics.split(",");
        for (int i = 0; i < split.length; i++) {
            arrayList.add(split[i]);
        }
        model.addAttribute("rentHouse", rentHouse);
        model.addAttribute("arrayList", arrayList);
        model.addAttribute("rentHouseFeaturesList", rentHouseFeaturesService.findAll());
        model.addAttribute("houseFloorEnums", HouseFloorEnum.values());
        model.addAttribute("houseWayEnums", RentHouseWayEnum.values());
        model.addAttribute("houseLeaseEnums", RentHouseLeaseEnum.values());
        model.addAttribute("houseTypeEnums", RentHouseTypeEnum.values());
        model.addAttribute("HouseOrientationEnums", HouseOrientationEnum.values());
        model.addAttribute("houseElevatorEnums", RentHouseElevatorEnum.values());
        model.addAttribute("houseFeaturesEnums", RentHouseFeaturesEnum.values());
        model.addAttribute("consultants",userService.findByUserType(UserRoleTypeEnum.CONSULTANT));
        model.addAttribute("rentHouseFeaturesList", rentHouseFeaturesService.findAll());
        List<HousingEstate> housingEstateList = housingEstateService.findByDistrictLike(rentHouse.getDistrict());
        model.addAttribute("housingEstateList", housingEstateList);
        return "admin/rent_house/edit";
    }

    /**
     * 编辑租房信息表单提交处理
     *
     * @param rentHouse
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(RentHouse rentHouse) {
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(rentHouse);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(validate);
        }
        if (rentHouse.getId() == null || rentHouse.getId().longValue() <= 0) {
            return Result.error(CodeMsg.RENT_HOUSE_NO_EXIST);
        }
        if (rentHouseService.isExistName(rentHouse.getName(), rentHouse.getId())) {
            return Result.error(CodeMsg.RENT_HOUSE_NAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库保存
        RentHouse findById = rentHouseService.find(rentHouse.getId());
        //讲提交的租房信息指定字段复制到已存在的rentHouse对象中,该方法会覆盖新字段内容
        BeanUtils.copyProperties(rentHouse, findById, "id", "createTime", "updateTime","user");
        if (rentHouseService.save(findById) == null) {
            return Result.error(CodeMsg.RENT_HOUSE_EDIT_ERROR);
        }
        operaterLogService.add("编辑租房，租房名：" + rentHouse.getName());
        return Result.success(true);
    }



    /**
     * 删除租房
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id") Long id) {
        try {
            rentHouseService.delete(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.RENT_HOUSE_DELETE_ERROR);
        }
        operaterLogService.add("删除租房，租房ID：" + id);
        return Result.success(true);
    }


}
