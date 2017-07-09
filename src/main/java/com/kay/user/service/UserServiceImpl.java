package com.kay.user.service;

import com.kay.common.uits.SecurityUitils;
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
        try {
            String encodePwd= SecurityUitils.encryptPassword(user.getPassword());
            user.setPassword(encodePwd);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加用户时出错！",e);
        }
        return userMapper.insertSelective(user);
    }

    /**
     * 登录验证 1.查询用户 2.匹配加密后的密码是否一致 3.返回验证是否通过
     * @param username
     * @param inputPwd
     * @return
     */
    @Override
    public User checkUser(String username,String inputPwd) {
        User user=userMapper.getUserByName(username);

        if(user==null){
            return null;
        }else {
            try {
               if(SecurityUitils.checkPassword(inputPwd,user.getPassword())){
                   return user;
               }else {
                   return null;
               }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("密码验证过程中出现错误！",e);
            }
        }
    }
}
