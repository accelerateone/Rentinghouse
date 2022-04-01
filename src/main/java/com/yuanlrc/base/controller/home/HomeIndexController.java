package com.yuanlrc.base.controller.home;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.entity.bridalChamber.*;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseInfoVo;
import com.yuanlrc.base.entity.houseInfoEnum.*;
import com.yuanlrc.base.service.admin.RentHouseService;
import com.yuanlrc.base.service.bridalChamber.HouseTypeService;
import com.yuanlrc.base.service.bridalChamber.NewHouseInfoService;
import com.yuanlrc.base.service.houseInfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequestMapping("/home/index")
@Controller
public class HomeIndexController {
    @Autowired
    private HouseLabelService houseLabelService;
    @Autowired
    private HouseInfoService houseInfoService;
    @Autowired
    private NewHouseInfoService newHouseInfoService;
    @Autowired
    private RentHouseService rentHouseService;
    @Autowired
    private HouseDivisionInfoService houseDivisionInfoService;
    @Autowired
    private HouseInspectionRecordService houseInspectionRecordService;
    @Autowired
    private HouseTypeService houseTypeService;

    /**
     * 二手房页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/secondHouse")
    public String index(Model model, HouseInfo houseInfo, PageBean<HouseInfo> pageBean) {
        model.addAttribute("price", PriceEnum.values());
        model.addAttribute("houseType", HouseTypeEnum.values());
        model.addAttribute("area", HouseAreaEnum.values());
        model.addAttribute("labels", houseLabelService.findAll());
        model.addAttribute("orientation", HouseOrientationEnum.values());
        model.addAttribute("floor", HouseFloorEnum.values());
        model.addAttribute("age", HouseAgeEnum.values());
        model.addAttribute("renovation", HouseRenovationEnum.values());
        model.addAttribute("purpose", HousePurposeEnum.values());
        model.addAttribute("elevator", HouseElevatorEnum.values());
        model.addAttribute("ownership", HouseOwnershipEnum.values());
        model.addAttribute("architectureType", HouseArchitectureTypeEnum.values());
        model.addAttribute("sales", HouseSalesEnum.values());
        model.addAttribute("index", 1);
        model.addAttribute("pageBean", houseInfoService.findList(houseInfo, pageBean));
        return "home/secondHouse";
    }

    @RequestMapping(value = "/house_info_detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        HouseInfo houseInfo = houseInfoService.find(id);
        List<HouseInfo> findTop8By = houseInfoService.findTop8ByDistrictLikeAndIdNot(houseInfo.getDistrict(), houseInfo.getId());
        model.addAttribute("houseInfo", houseInfo);
        model.addAttribute("houseDivisionInfo", houseDivisionInfoService.findByHouseInfoId(id));
        model.addAttribute("houseInspectionRecord", houseInspectionRecordService.findByHouseInfoId(id));
        model.addAttribute("withinSevenDays", houseInspectionRecordService.findWithinSevenDays(id));
        model.addAttribute("withinThirtyDays", houseInspectionRecordService.findWithinThirtyDays(id));
        model.addAttribute("findTop8By", findTop8By);
        model.addAttribute("sales", HouseSalesEnum.values());
        model.addAttribute("index", 1);
        return "home/detail";
    }

    /**
     * 新房
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/bridalChamberList")
    public String bridalChamberList(Model model) {
        model.addAttribute("decorateStates", DecorateStateEnum.values());
        model.addAttribute("openingTimes", OpeningTimeEnum.values());
        model.addAttribute("propertyTypes", PropertyTypeEnum.values());
        model.addAttribute("sellingTheStates", SellingTheStateEnum.values());
        model.addAttribute("index", 2);
        return "home/bridalChamber/bridal_chamber_list";
    }

    @RequestMapping(value = "/bridalChamberIndex")
    public String bridalChamberIndex(Model model) {
        model.addAttribute("topThree", newHouseInfoService.findTop3());
        model.addAttribute("houseInfoTopThree", houseInfoService.findTop3By());
        model.addAttribute("rentHouseTopThree", rentHouseService.findTop3By());
        model.addAttribute("count", newHouseInfoService.count());
        return "home/bridalChamber/index";
    }


    @RequestMapping(value = "/particulars/{id}")
    public String particulars(Model model, @PathVariable("id") Long id) {
        NewHouseInfo newHouseInfo = newHouseInfoService.find(id);
        model.addAttribute("newHouseInfo", newHouseInfo);
        model.addAttribute("firstSix", newHouseInfoService.firstSixByPropertyType(newHouseInfo.getPropertyType().getCode(), newHouseInfo.getCity()));
        model.addAttribute("houseType", houseTypeService.findByNewHouseInfo_Id(id));
        model.addAttribute("houseTypeThree", houseTypeService.findTop3ByNewHouseInfo_Id(id));
        model.addAttribute("index", 2);
        return "home/bridalChamber/particulars";
    }


    /**
     * 二手房条件查询
     */
    @PostMapping("/secondHouse/findList")
    public String findList(@RequestBody HouseInfoVo houseInfoVo, PageBean<HouseInfo> pageBean, Model model) {
        model.addAttribute("pageBean", houseInfoService.findListByTerm(houseInfoVo, pageBean));
        return "home/findList";
    }
}
