package com.yuanlrc.base.controller.bridalChamber;

import com.alibaba.fastjson.JSONObject;
import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.bridalChamber.EffectPicture;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.service.admin.EffectPictureService;
import com.yuanlrc.base.util.ValidateEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@RequestMapping("/admin/effectPicture")
@Controller
public class EffectPictureController {

    @Autowired
    private EffectPictureService effectPictureService;

    @RequestMapping("/saveAll")
    @ResponseBody
    public Result<List<EffectPicture>> saveAll(String filePaths, NewHouseInfo newHouseInfo){
        //验证实体是否合法
        CodeMsg validate = ValidateEntityUtil.validate(newHouseInfo);
        if (validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if (StringUtils.isEmpty(filePaths) || ("null").equals(filePaths)){
            return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_ADD_EFFECTPICTUREITEMS_ERROR);
        }
        List<EffectPicture> saveAllEffectPictureList = new ArrayList<>();
        if (!StringUtils.isEmpty(filePaths)){
            try {
                List<EffectPicture> effectPictures = JSONObject.parseArray(filePaths, EffectPicture.class);
                List<EffectPicture> addRoomInfoDocuments = effectPictures.stream().filter(o -> !o.getEffectPicturePath().equals("null")).collect(Collectors.toList());
                saveAllEffectPictureList = effectPictureService.saveAll(addRoomInfoDocuments);
            }catch (Exception e){
                return Result.error(CodeMsg.ADMIN_NEWHOUSEINFO_ADD_EDIT_ERROR);
            }
           
        }
        return  Result.success(saveAllEffectPictureList);
    }
}
