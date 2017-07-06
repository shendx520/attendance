package com.kay.user.service;

import com.kay.user.dao.UserMapper;
import com.kay.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kay on 2017/7/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public int insertUser(User user,User u2) {
        userMapper.insertSelective(user);
        userMapper.insertSelective(u2);
        return 0;
    }
}
