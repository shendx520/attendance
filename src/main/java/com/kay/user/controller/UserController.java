package com.kay.user.controller;

import com.kay.user.entity.User;
import com.kay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kay on 2017/7/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String user(){
        User user=new User();
        user.setUsername("kay");
        user.setRealName("kay");
        user.setPassword("123456");
        User user2=new User();
        user2.setId(1L);
        user2.setUsername("kay");
        user2.setRealName("kay");
        user2.setPassword("123456");
        userService.insertUser(user,user2);
        return "user";
    }
}
