package com.yuanlrc.base.controller.websoket;


import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.bridalChamber.HomeUser;
import com.yuanlrc.base.service.admin.UserService;
import com.yuanlrc.base.util.SessionUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/websocket")
public class WebSocketController {
    @Autowired
    private UserService userService;

    @RequestMapping("/home/websocket")
    public String homeWebSocket(Long userID, Model model) {
        model.addAttribute("homeUser",SessionUtil.getHomeUser());
        return "home/websocket";
    }

    @RequestMapping("/admin/websocket")
    public String adminWebSocket(Long userID, Model model) {
        model.addAttribute("adminUser",SessionUtil.getLoginedUser());
        return "home/websocket";
    }

//    @RequestMapping("/websocket/{userID}")
//    public String webSocket(Long userID, Model model) {
//        model.addAttribute("user", userService.find(userID));
//        return "home/websocket";
//    }



}
