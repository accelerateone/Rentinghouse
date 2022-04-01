package com.yuanlrc.base.controller.bridalChamber;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.bridalChamber.HouseType;
import com.yuanlrc.base.entity.bridalChamber.HousingCharacteristics;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.service.bridalChamber.HouseTypeService;
import com.yuanlrc.base.service.bridalChamber.NewHouseInfoService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;

@Controller
@RequestMapping("/admin/houseType")
public class HouseTypeController {

    @Autowired
    private HouseTypeService houseTypeService;

    @Autowired
    private NewHouseInfoService newHouseInfoService;

    /**
     * list列表
     *
     * @param model
     * @param pageBean
     * @param houseType
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, PageBean<HouseType> pageBean, HouseType houseType) {
        model.addAttribute("newHouseInfoName",houseType.getNewHouseInfo()==null?"":houseType.getNewHouseInfo().getName());   //楼盘名称
        model.addAttribute("pageBean", houseTypeService.findAllByNewHouseInfoName(pageBean, houseType));
        return "admin/house_type/list";
    }

    /**
     * 进入保存页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("newHouseInfos", newHouseInfoService.findAll());
        return "admin/house_type/add";
    }

    /**
     * 进行保存
     * @param houseType
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HouseType houseType) {
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseType);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()) {
            return Result.error(validate);
        }

        //一切验证合法,进行保存
        if (houseTypeService.save(houseType) == null) {
            return Result.error(CodeMsg.ADMIN_HOUSETYPE_ADD_ERROR);
        }

        return Result.success(true);
    }

    /**
     * 进入编辑页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model,@RequestParam(name="id")Long id){
        model.addAttribute("houseType",houseTypeService.find(id));
        model.addAttribute("newHouseInfos", newHouseInfoService.findAll());
        return "admin/house_type/edit";
    }

    /**
     * 进行编辑
     * @param houseType
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HouseType houseType){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseType);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }

        //一切验证合法,进行编辑
        if (houseTypeService.save(houseType) == null){
            return Result.error(CodeMsg.ADMIN_HOUSETYPE_EDIT_ERROR);
        }
        return Result.success(true);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value="/del",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> del(@RequestParam(name="id")Long id){
        try {
            houseTypeService.del(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.ADMIN_HOUSETYPE_DELETE_ERROR);
        }
        return Result.success(true);
    }



}
