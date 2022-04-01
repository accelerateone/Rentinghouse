package com.yuanlrc.base.controller.home.rentHouse;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.entity.houseInfoEnum.HouseFloorEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseOrientationEnum;
import com.yuanlrc.base.entity.rentHouse.*;
import com.yuanlrc.base.service.admin.RentHouseFeaturesService;
import com.yuanlrc.base.service.admin.RentHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 前台租房控制层
 * @author wangzihan
 * @date : 2021/1/11 11:29
 */
@RequestMapping("/home/rentHouse")
@Controller
public class HomeRentHouseController {

    @Autowired
    private RentHouseService rentHouseService;
    @Autowired
    private RentHouseFeaturesService rentHouseFeaturesService;

    @RequestMapping(value="/list")
    public String list(RentHouse rentHouse, PageBean<RentHouse> pageBean, Model model){
        model.addAttribute("rentHouseWayEnums", RentHouseWayEnum.values());
        model.addAttribute("houseTypeEnums", RentHouseTypeEnum.values());
        model.addAttribute("houseOrientationEnums", HouseOrientationEnum.values());
        model.addAttribute("rentHouseFeaturesList", rentHouseFeaturesService.findAll());
        model.addAttribute("leaseTypeEnums", RentHouseLeaseEnum.values());
        model.addAttribute("priceEnums", RentHoursePriceEnum.values());
        model.addAttribute("floorTypeEnums", HouseFloorEnum.values());
        model.addAttribute("elevatorEnums", RentHouseElevatorEnum.values());
        model.addAttribute("pageBean",rentHouseService.findList(rentHouse, pageBean,1));
        model.addAttribute("rentHouseList", rentHouseService.findAll());
        model.addAttribute("index", 3);
        return "home/rent_house/list";
    }

    //分页多条件查询
    @PostMapping("/conditionsQuery")
    public String conditionsQuery(@RequestBody RentHouseQueryVo rentHouseQueryVo, PageBean<RentHouse> pageBean, Model model){
        PageBean<RentHouse> rentHousePageBean = rentHouseService.conditionsQuery(rentHouseQueryVo, pageBean);
        model.addAttribute("pageBean",rentHousePageBean);
        model.addAttribute("count",rentHousePageBean.getTotal());
        return "home/rent_house/conditions_query";
    }


    @RequestMapping(value="/details")
    public String details(@RequestParam("id")Long id,Model model){
        RentHouse rentHouse = rentHouseService.find(id);
        List<RentHouse> findTop4By = rentHouseService.findTop4ByHousingEstate_NameAndIdNot(
                rentHouse.getHousingEstate().getName(),rentHouse.getId());
        List<RentHouse> findTop8ByTownLike = rentHouseService.findTop8ByDistrictLikeAndCityLikeAndProvinceLikeAndIdNot(rentHouse.getDistrict(),
                rentHouse.getCity(),rentHouse.getProvince(),rentHouse.getId());
        model.addAttribute("rentHouse",rentHouse);
        model.addAttribute("findTop4By",findTop4By);
        model.addAttribute("findTop8ByTownLike",findTop8ByTownLike);
        model.addAttribute("index", 3);
        return "home/rent_house/details";
    }

}
