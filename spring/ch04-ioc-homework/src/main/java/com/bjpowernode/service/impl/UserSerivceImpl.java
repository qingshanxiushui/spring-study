package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.MySqlUserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service("userService")
public class UserSerivceImpl implements UserSerivce {

    //引用类型 @Autowired, @Resource
    //@Autowired
    @Resource
    private UserDao userDao;


    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }
}
