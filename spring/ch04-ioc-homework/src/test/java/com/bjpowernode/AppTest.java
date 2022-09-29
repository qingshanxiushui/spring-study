package com.bjpowernode;

import static org.junit.Assert.assertTrue;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserSerivce;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void test01(){
        String config="applicationContet.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserSerivce serivce = (UserSerivce) ctx.getBean("userService");
        serivce.addUser(null);

//        SysUser user = new SysUser();
//        user.setName("lisi");
//        user.setAge(20);
//        serivce.addUser(user);


        UserDao dao  = (UserDao) ctx.getBean("mysqlDao");
        dao.insertUser(null);
    }
}
