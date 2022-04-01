package com.yuanlrc.base.controller.admin;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.admin.HousingEstateService;
import com.yuanlrc.base.util.SessionUtil;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 小区控制层
 * @author wangzihan
 * @date : 2021/1/7 13:48
 */
@RequestMapping("/admin/housingEstate")
@Controller
public class HousingEstateController {


    @Autowired
    private HousingEstateService housingEstateService;
    @Autowired
    private OperaterLogService operaterLogService;


    /**
     * 小区列表页面
     * @param model
     * @param housingEstate
     * @param pageBean
     * @return
     */
    @RequestMapping(value="/list")
    public String list(Model model, HousingEstate housingEstate, PageBean<HousingEstate> pageBean){
        model.addAttribute("title", "小区列表");
        model.addAttribute("name", housingEstate.getName());
        model.addAttribute("pageBean", housingEstateService.findList(housingEstate, pageBean));
        return "admin/housing_estate/list";
    }

    /**
     * 新增小区页面
     * @return
     */
    @RequestMapping(value="/add",method= RequestMethod.GET)
    public String add(){
        return "admin/housing_estate/add";
    }


    /**
     * 小区添加表单提交处理
     * @param housingEstate
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HousingEstate housingEstate){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(housingEstate);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        User loginedUser = SessionUtil.getLoginedUser();
        housingEstate.setUser(loginedUser);
        //判断小区名是否存在
        if(housingEstateService.isExistName(housingEstate.getName(), 0L)){
            return Result.error(CodeMsg.HOUSING_ESTATE_NAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库新增
        if(housingEstateService.save(housingEstate) == null){
            return Result.error(CodeMsg.HOUSING_ESTATE_ADD_ERROR);
        }
        operaterLogService.add("添加小区，小区名：" + housingEstate.getName());
        return Result.success(true);
    }

    /**
     * 删除小区
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id")Long id){
        try {
            housingEstateService.delete(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.HOUSING_ESTATE_DELETE_ERROR);
        }
        operaterLogService.add("删除小区，小区ID：" + id);
        return Result.success(true);
    }
    
    
}
