package com.udacity.jwdnd.course1.cloudstorage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String getHomePage(Model model){
        return "home";
    }
}
//test