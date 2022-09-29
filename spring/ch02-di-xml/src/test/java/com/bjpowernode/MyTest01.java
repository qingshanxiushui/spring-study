package com.bjpowernode;

import com.bjpowernode.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 *
 */
public class MyTest01 {

    @Test
    public void test01(){
        String config="ba01/applicationContext.xml";
        ApplicationContext ctx  = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ctx.getBean("myStudent");

        System.out.println("student="+student);


        Date date = (Date) ctx.getBean("mydate");
        System.out.println("date==="+date);
    }
}
