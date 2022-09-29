package com.bjpowernode;

import com.bjpowernode.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 */
public class MyTest06 {



    @Test
    public void test01(){
        String config= "ba06/applicationContext.xml";
        ApplicationContext ctx  = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ctx.getBean("myStudent");

        System.out.println("student="+student);

    }
}
