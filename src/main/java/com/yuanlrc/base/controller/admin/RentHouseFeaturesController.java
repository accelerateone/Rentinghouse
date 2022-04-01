package com.yuanlrc.base.controller.admin;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.rentHouse.RentHouseFeatures;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.admin.RentHouseFeaturesService;
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
 * 租房特色控制层
 * @author wangzihan
 * @date : 2021/1/9 17:23
 */

@Controller
@RequestMapping("/admin/rentHouseFeatures")
public class RentHouseFeaturesController {

    @Autowired
    private RentHouseFeaturesService rentHouseFeaturesService;
    @Autowired
    private OperaterLogService operaterLogService;

    /**
     * 租房特色列表页面
     * @param model
     * @param rentHouseFeatures
     * @param pageBean
     * @return
     */
    @RequestMapping(value="/list")
    public String list(Model model, RentHouseFeatures rentHouseFeatures, PageBean<RentHouseFeatures> pageBean){
        model.addAttribute("title", "租房特色列表");
        model.addAttribute("name", rentHouseFeatures.getName());
        model.addAttribute("pageBean", rentHouseFeaturesService.findList(pageBean,rentHouseFeatures));
        return "admin/rent_house_features/list";
    }

    /**
     * 新增租房特色页面
     * @return
     */
    @RequestMapping(value="/add",method= RequestMethod.GET)
    public String add(){
        return "admin/rent_house_features/add";
    }

    /**
     * 租房特色添加表单提交处理
     * @param rentHouseFeatures
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(RentHouseFeatures rentHouseFeatures){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(rentHouseFeatures);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        //判断租房特色名是否存在
        if(rentHouseFeaturesService.isExistName(rentHouseFeatures.getName(), 0L)){
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_NAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库新增
        if(rentHouseFeaturesService.save(rentHouseFeatures) == null){
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_ADD_ERROR);
        }
        operaterLogService.add("添加租房特色，租房特色名：" + rentHouseFeatures.getName());
        return Result.success(true);
    }

    /**
     * 租房特色编辑页面
     * @param model
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(Model model,@RequestParam(name="id")Long id){
        model.addAttribute("rentHouseFeatures", rentHouseFeaturesService.find(id));
        return "admin/rent_house_features/edit";
    }

    /**
     * 编辑租房特色信息表单提交处理
     * @param rentHouseFeatures
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(RentHouseFeatures rentHouseFeatures){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(rentHouseFeatures);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if(rentHouseFeatures.getId() == null || rentHouseFeatures.getId().longValue() <= 0){
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_NO_EXIST);
        }
        if(rentHouseFeaturesService.isExistName(rentHouseFeatures.getName(), rentHouseFeatures.getId())){
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_NAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库保存
        RentHouseFeatures findById = rentHouseFeaturesService.find(rentHouseFeatures.getId());
        //讲提交的租房特色信息指定字段复制到已存在的rentHouseFeatures对象中,该方法会覆盖新字段内容
        BeanUtils.copyProperties(rentHouseFeatures, findById, "id","createTime","updateTime");
        if(rentHouseFeaturesService.save(findById) == null){
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_EDIT_ERROR);
        }
        operaterLogService.add("编辑租房特色，租房特色名：" + rentHouseFeatures.getName());
        return Result.success(true);
    }

    /**
     * 删除租房特色
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id")Long id){
        try {
            rentHouseFeaturesService.delete(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.RENT_HOUSE_FEATURES_DELETE_ERROR);
        }
        operaterLogService.add("添加租房特色，租房特色ID：" + id);
        return Result.success(true);
    }
    
    
}
