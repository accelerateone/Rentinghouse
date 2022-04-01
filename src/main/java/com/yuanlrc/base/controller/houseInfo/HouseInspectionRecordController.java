package com.yuanlrc.base.controller.houseInfo;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseInspectionRecord;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.houseInfo.HouseInfoService;
import com.yuanlrc.base.service.houseInfo.HouseInspectionRecordService;
import com.yuanlrc.base.service.admin.HousingEstateService;
import com.yuanlrc.base.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 带看记录后台控制器
 */
@RequestMapping("/admin/houseInspectionRecord")
@Controller
public class HouseInspectionRecordController {
    @Autowired
    private HouseInspectionRecordService houseInspectionRecordService;
    @Autowired
    private HouseInfoService houseInfoService;
    @Autowired
    private OperaterLogService operaterLogService;
    @Autowired
    private HousingEstateService housingEstateService;


    @RequestMapping("/list")
    public String list(Model model, HouseInspectionRecord houseInspectionRecord, PageBean<HouseInspectionRecord> pageBean){
        model.addAttribute("title","带看记录列表");
        model.addAttribute("username",houseInspectionRecord.getUser() == null?"":houseInspectionRecord.getUser().getUsername());
        model.addAttribute("pageBean",houseInspectionRecordService.findList(houseInspectionRecord,pageBean));
        return "admin/house_inspection_record/list";
    }

    /**
     * 小区房屋二级联动
     * @return
     */
    @RequestMapping(value="/add/house",method=RequestMethod.POST)
    @ResponseBody
    public List<HouseInfo> houseInfos(@Param("id") Long id){
        return houseInfoService.findByHousingEstateId(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("housingEstate",housingEstateService.findAll());
        return "admin/house_inspection_record/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HouseInspectionRecord houseInspectionRecord){
        User loginedUser = SessionUtil.getLoginedUser();
        if (loginedUser==null){
            return Result.error(CodeMsg.USER_SESSION_EXPIRED);
        }
        if (houseInspectionRecord.getHousingEstate()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_ERROR_2);
        }
        if (houseInspectionRecord.getHouseInfo()==null){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_ERROR);
        }
        houseInspectionRecord.setUser(loginedUser);
        if (!houseInspectionRecordService.save1(houseInspectionRecord)){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_ADD_FAIL);
        }
        operaterLogService.add("添加带看记录,经纪人姓名:"+loginedUser.getUsername());
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name = "id",required = true) Long id){
        try {
            houseInspectionRecordService.delete(id);
        }catch (Exception e){
            return Result.error(CodeMsg.ADMIN_HOUSE_RECORD_DELETE_FAIL);
        }
        operaterLogService.add("删除带看记录，带看记录id：" + id);
        return Result.success(true);
    }
}
