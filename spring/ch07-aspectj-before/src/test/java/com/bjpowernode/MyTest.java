package com.bjpowernode;

import com.bjpowernode.service.SomeService;
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

        //没有加入代理的处理：
        // 1）目标方法执行时，没有切面功能的。
        // 2) service对象没有被改变
        /*SomeService service = (SomeService) ctx.getBean("someService");
        //service==com.bjpowernode.service.impl.SomeServiceImpl
        System.out.println("service=="+service.getClass().getName());
        service.doSome("lisi", 20);*/
    }

    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //加入代理的处理：
        // 1）目标方法执行时，有切面功能的。
        // 2) service对象是改变后的 代理对象 com.sun.proxy.$Proxy8
        SomeService service = (SomeService) ctx.getBean("someService");
        //com.sun.proxy.$Proxy8 代理   $Proxy==ServiceProxy
        //System.out.println("service=="+service.getClass().getName());
        //代理对象，调用方法，才有切面的功能增强
        service.doSome("lisi", 20);
    }

    @Test
    public void test03(){
        ServiceProxy2 service = new ServiceProxy2();
        service.doSome("lisi", 20);
    }


    @Test
    public void test04(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        SomeService service = (SomeService) ctx.getBean("someService");

        //service.doSome("lisi", 20);

        service.doOther();
    }
}
