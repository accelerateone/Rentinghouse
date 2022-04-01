package com.yuanlrc.base.controller.bridalChamber;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.dao.bridalChamber.HousingCharacteristicsDao;
import com.yuanlrc.base.entity.bridalChamber.*;
import com.yuanlrc.base.service.bridalChamber.HousingCharacteristicsService;
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
@RequestMapping("/admin/housingCharacteristics")
public class HousingCharacteristicsController {

    @Autowired
    private HousingCharacteristicsService housingCharacteristicsService;

    /**
     * list页面
     * @param model
     * @param pageBean
     * @param housingCharacteristics
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, PageBean<HousingCharacteristics> pageBean,HousingCharacteristics housingCharacteristics){
        model.addAttribute("name",housingCharacteristics.getName());
        model.addAttribute("pageBean",housingCharacteristicsService.findAllByHousingCharacteristicsName(pageBean,housingCharacteristics));
        return "admin/housing_characteristics/list";
    }

    /**
     * 进入保存页面
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model){
        return "admin/housing_characteristics/add";
    }

    /**
     * 进行保存
     * @param housingCharacteristics
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HousingCharacteristics housingCharacteristics){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(housingCharacteristics);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }

        //一切验证合法,进行保存
        if (housingCharacteristicsService.save(housingCharacteristics) == null){
            return Result.error(CodeMsg.ADMIN_HOUSINGCHARACTERISTICS_ADD_ERROR);
        }
        return Result.success(true);
    }

    /**
     * 进入编辑页面
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id")Long id){
        model.addAttribute("housingCharacteristics",housingCharacteristicsService.find(id));
        return "admin/housing_characteristics/edit";
    }

    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HousingCharacteristics housingCharacteristics){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(housingCharacteristics);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }


        //一切验证合法,进行保存
        if (housingCharacteristicsService.save(housingCharacteristics) == null){
            return Result.error(CodeMsg.ADMIN_HOUSINGCHARACTERISTICS_EDIT_ERROR);
        }

        return Result.success(true);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> del(@RequestParam("id")Long id){
        try {
            housingCharacteristicsService.del(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_HOUSINGCHARACTERISTICS_DELETE_ERROR);
        }
        return Result.success(true);
    }



}
