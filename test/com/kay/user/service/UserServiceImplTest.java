package com.kay.user.service;

import com.kay.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by kay on 2017/7/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void insertUser() throws Exception {
        User user=new User();
        user.setUsername("fen");
        user.setRealName("cxf");
        user.setPassword("123456");
        int count=userService.insertUser(user);
        System.out.println("测试结果:"+count);
    }

    @Test
    public void checkUser() throws Exception {
        User f=userService.checkUser("kay","123456");
        System.out.println("-----------------------------"+f);
    }
}