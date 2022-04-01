package com.yuanlrc.base.controller.bridalChamber;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfoVO;
import com.yuanlrc.base.service.bridalChamber.NewHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/home/homeNewHouseInfo")
public class HomeNewHouseInfoController {

    @Autowired
    private NewHouseInfoService newHouseInfoService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public String list(@RequestBody NewHouseInfoVO newHouseInfoVO,Model model, PageBean<NewHouseInfo> pageBean) {
        PageBean<NewHouseInfo> newHouseInfoPageBean = newHouseInfoService.specificationNewHouseInfo(pageBean, newHouseInfoVO);
        model.addAttribute("pageBean",newHouseInfoPageBean);
        model.addAttribute("count",newHouseInfoPageBean.getTotal());
        return "home/bridalChamber/bridal_chamber_page_list";
    }

}
