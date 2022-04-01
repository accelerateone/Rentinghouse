package com.yuanlrc.base.controller.houseInfo;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.houseInfo.HouseLabel;
import com.yuanlrc.base.service.admin.OperaterLogService;
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

/**
 * 房屋标签后台控制器
 */
@RequestMapping("/admin/houseLabel")
@Controller
public class HouseLabelController {
    @Autowired
    private HouseLabelService houseLabelService;
    @Autowired
    private OperaterLogService operaterLogService;

    @RequestMapping("/list")
    public String list(Model model, HouseLabel houseLabel, PageBean<HouseLabel> pageBean){
        model.addAttribute("title","房屋标签列表");
        model.addAttribute("name",houseLabel.getName());
        model.addAttribute("pageBean",houseLabelService.findList(houseLabel,pageBean));
        return "admin/house_label/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "admin/house_label/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HouseLabel houseLabel){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseLabel);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        HouseLabel byName = houseLabelService.findByName(houseLabel.getName());
        //判断标签名是否重复
        if (byName!=null&&byName.getId()!=null){
            return Result.error(CodeMsg.ADMIN_HOUSE_LABEL_ADD_ERROR);
        }
        if (houseLabelService.save(houseLabel)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_LABEL_ADD_FAIL);
        }
        operaterLogService.add("添加房屋标签，标签名：" + houseLabel.getName());
        return Result.success(true);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model,@RequestParam(name = "id",required = true) Long id){
        model.addAttribute("houseLabel",houseLabelService.find(id));
        return "admin/house_label/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(HouseLabel houseLabel){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(houseLabel);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        //判断标签名是否重复
        if (houseLabelService.findByName(houseLabel.getName())!=null&&houseLabelService.findByName(houseLabel.getName()).getId()!=null){
            if (houseLabelService.findByName(houseLabel.getName()).getId().longValue()!=houseLabel.getId().longValue()){
                return Result.error(CodeMsg.ADMIN_HOUSE_LABEL_ADD_ERROR);
            }
        }
        HouseLabel findById = houseLabelService.find(houseLabel.getId());
        BeanUtils.copyProperties(houseLabel,findById,"id","createTime","updateTime");
        if (houseLabelService.save(findById)==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_LABEL_EDIT_FAIL);
        }
        operaterLogService.add("编辑房屋标签，标签名：" + houseLabel.getName());
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id",required = true) Long id){
        try {
            houseLabelService.delete(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_HOUSE_LABEL_DELETE_FAIL);
        }
        operaterLogService.add("删除房屋标签，标签id：" + id);
        return Result.success(true);
    }
}
