package com.kay.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kay on 2017/7/7.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public String login(){
        return "login";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(){

        return "success";
    }
}
