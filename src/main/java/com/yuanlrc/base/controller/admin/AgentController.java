package com.yuanlrc.base.controller.admin;

import com.yuanlrc.base.bean.CodeMsg;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.bean.Result;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.service.admin.OperaterLogService;
import com.yuanlrc.base.service.admin.RoleService;
import com.yuanlrc.base.service.admin.UserService;
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
 * 经纪人管理控制层
 * @author wangzihan
 * @date : 2021/1/8 14:43
 */

@RequestMapping("/admin/agent")
@Controller
public class AgentController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OperaterLogService operaterLogService;
    
    /**
     * 经纪人列表页面
     * @param model
     * @param user
     * @param pageBean
     * @return
     */
    @RequestMapping(value="/list")
    public String list(Model model, User user, PageBean<User> pageBean){
        model.addAttribute("title", "经纪人列表");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("pageBean", userService.findList(pageBean,user.getUsername(),UserRoleTypeEnum.AGENT));
        return "admin/agent/list";
    }

    /**
     * 新增经纪人页面
     * @param model
     * @return
     */
    @RequestMapping(value="/add",method= RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("roles", roleService.findAllByRoleType(UserRoleTypeEnum.AGENT));
        return "admin/agent/add";
    }

    /**
     * 经纪人添加表单提交处理
     * @param user
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(User user){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(user);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if(user.getRole() == null || user.getRole().getId() == null){
            return Result.error(CodeMsg.AGENT_USER_ROLE_EMPTY);
        }
        if (user.getCertificate() == null || "".equals(user.getCertificate())){
            return Result.error(CodeMsg.AGENT_USER_CERTIFICATE_EMPTY);
        }

        if (user.getYearsOfService() == null || "".equals(user.getYearsOfService())){
            return Result.error(CodeMsg.AGENT_USER_YEARSOFSERVICE_EMPTY);
        }

        //判断经纪人名是否存在
        if(userService.isExistUsername(user.getUsername(), 0L)){
            return Result.error(CodeMsg.AGENT_USERNAME_EXIST);
        }
        user.setUserType(UserRoleTypeEnum.AGENT);
        //到这说明一切符合条件，进行数据库新增
        if(userService.save(user) == null){
            return Result.error(CodeMsg.AGENT_USE_ADD_ERROR);
        }
        operaterLogService.add("添加经纪人，经纪人名：" + user.getUsername());
        return Result.success(true);
    }

    /**
     * 经纪人编辑页面
     * @param model
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(Model model,@RequestParam(name="id")Long id){
        model.addAttribute("roles", roleService.findAllByRoleType(UserRoleTypeEnum.AGENT));
        model.addAttribute("user", userService.find(id));
        return "admin/agent/edit";
    }

    /**
     * 编辑经纪人信息表单提交处理
     * @param user
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(User user){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidateEntityUtil.validate(user);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.error(validate);
        }
        if(user.getRole() == null || user.getRole().getId() == null){
            return Result.error(CodeMsg.AGENT_USER_ROLE_EMPTY);
        }
        if (user.getCertificate() == null || "".equals(user.getCertificate())){
            return Result.error(CodeMsg.AGENT_USER_CERTIFICATE_EMPTY);
        }
        if (user.getYearsOfService() == null || "".equals(user.getYearsOfService())){
            return Result.error(CodeMsg.AGENT_USER_YEARSOFSERVICE_EMPTY);
        }
        if(user.getId() == null || user.getId().longValue() <= 0){
            return Result.error(CodeMsg.AGENT_USE_NO_EXIST);
        }
        if(userService.isExistUsername(user.getUsername(), user.getId())){
            return Result.error(CodeMsg.AGENT_USERNAME_EXIST);
        }
        //到这说明一切符合条件，进行数据库保存
        User findById = userService.find(user.getId());
        //讲提交的经纪人信息指定字段复制到已存在的user对象中,该方法会覆盖新字段内容
        BeanUtils.copyProperties(user, findById, "id","createTime","updateTime","userType");
        if(userService.save(findById) == null){
            return Result.error(CodeMsg.AGENT_USE_EDIT_ERROR);
        }
        operaterLogService.add("编辑经纪人，经纪人名：" + user.getUsername());
        return Result.success(true);
    }

    /**
     * 删除经纪人
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id")Long id){
        try {
            userService.delete(id);
        } catch (Exception e) {
            return Result.error(CodeMsg.AGENT_USE_DELETE_ERROR);
        }
        operaterLogService.add("删除经纪人，经纪人ID：" + id);
        return Result.success(true);
    }
    


}
