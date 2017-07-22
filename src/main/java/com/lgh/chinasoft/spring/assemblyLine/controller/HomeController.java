package com.lgh.chinasoft.spring.assemblyLine.controller;

import com.lgh.chinasoft.spring.assemblyLine.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/22.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("test",userService.test());
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "/assembly/home/main";
    }
}
