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
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");

        String ret = service.doFirst("lisi");
        //String ret = myAspect.myAround();
        System.out.println("ret调用目标方法的结果=="+ret);
    }


    @Test
    public void test03(){
        MyHandler handler = new MyHandler();
        String res  = handler.doFirst();
        System.out.println("res=="+res);
    }

}
