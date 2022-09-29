package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("mysqlDao")
public class MySqlUserDao implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("====执行了mysql数据库的insert操作===");
    }
}
