package com.yuanlrc.base.controller.houseInfo;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.houseInfo.HousePictures;
import com.yuanlrc.base.service.admin.HousingEstateService;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.houseInfo.HouseInfoService;
import com.yuanlrc.base.service.houseInfo.HousePicturesService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin/housePictures")
@Controller
public class HousePicturesController {
    @Autowired
    private HousePicturesService housePicturesService;
    @Autowired
    private OperaterLogService operaterLogService;
    @Autowired
    private HousingEstateService housingEstateService;
    @Autowired
    private HouseInfoService houseInfoService;

    @RequestMapping("/list")
    public String list(Model model, HousePictures housePictures, PageBean<HousePictures> pageBean){
        model.addAttribute("title","房屋图片列表");
        model.addAttribute("estateName",housePictures.getHousingEstate()==null?"":housePictures.getHousingEstate().getName());
        model.addAttribute("pageBean",housePicturesService.findList(housePictures,pageBean));
        return "admin/house_pictures/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("housingEstate",housingEstateService.findAll());
        return "admin/house_pictures/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HousePictures housePictures){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(housePictures);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if (housePicturesService.save(housePictures)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_PICTURE_ADD_FAIL);
        }
        operaterLogService.add("添加房屋照片，房间号："+housePictures.getHouseInfo().getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HousePictures housePictures){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(housePictures);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        HousePictures findById = housePicturesService.find(housePictures.getId());
        BeanUtils.copyProperties(housePictures,findById,"id","createTime","updateTime");
        if (housePicturesService.save(findById)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_PICTURE_EDIT_FAIL);
        }
        operaterLogService.add("编辑房屋照片，房间号："+housePictures.getHouseInfo().getHouseNumber());
        return Result.success(true);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model,@RequestParam(name = "id",required = true) Long id){
        model.addAttribute("housePictures",housePicturesService.find(id));
        model.addAttribute("houseInfo",houseInfoService.findByHousingEstateId(housePicturesService.find(id).getHousingEstate().getId().longValue()));
        model.addAttribute("housingEstate",housingEstateService.findAll());
        return "admin/house_pictures/edit";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id",required = true) Long id){
        try{
            housePicturesService.delete(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_HOUSE_PICTURE_ADD_FAIL);
        }
        operaterLogService.add("删除房屋照片，照片id："+id);
        return Result.success(true);
    }
}
