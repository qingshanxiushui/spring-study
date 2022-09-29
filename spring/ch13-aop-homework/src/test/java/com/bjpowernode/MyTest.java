package com.bjpowernode;

import com.bjpowernode.service.NumberSerivce;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        NumberSerivce serivce = (NumberSerivce) ctx.getBean("numberService");

        Integer rs  = serivce.addNumber(10, -20,90);
        System.out.println("rs==="+rs);
    }
}
