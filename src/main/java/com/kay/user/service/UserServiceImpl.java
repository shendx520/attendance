package com.kay.user.service;

import com.kay.user.dao.UserMapper;
import com.kay.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kay on 2017/7/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
       return userMapper.insertSelective(user);
    }
}
