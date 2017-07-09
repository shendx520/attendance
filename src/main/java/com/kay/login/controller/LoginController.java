package com.kay.login.controller;

import com.kay.user.entity.User;
import com.kay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by kay on 2017/7/7.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public String check(HttpServletRequest request) throws ServletException, IOException {

        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");

        User user= userService.checkUser(username,password);
        if(user!=null){
            request.getSession().setAttribute("userinfo",user);
            return "login_success";
        }else {
            return "login_fail";
        }

    }
}
