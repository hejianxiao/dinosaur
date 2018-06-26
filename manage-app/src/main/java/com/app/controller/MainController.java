package com.app.controller;

import com.app.entity.sys.User;
import com.app.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建人: Hjx
 * Date: 2018/6/21
 * Description:
 */
@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }




    @RequestMapping("/login")
    public String login() {
        User user = userService.selectById("1");
        System.out.println(user);
        return "login";
    }







    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/401")
    public String accessDenied() {
        return "401";
    }
}
