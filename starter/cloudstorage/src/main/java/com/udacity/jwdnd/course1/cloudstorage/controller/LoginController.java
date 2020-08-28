package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*using the controller classes we can create methods that are responsible for
choosing the correct template and populating it with data*/
@Controller
@RequestMapping("/login")
public class LoginController {
    /*this helps up by telling spring where to route the page request to
    * So this will map it to the login page*/
    @GetMapping
    public String getLoginPage() {
        /*we want to return a string of where the page maps to because spring
        * will try to use the string we return as a prefix to the html page we want*/
        return "login";
    }
}
