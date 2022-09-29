package com.bjpowernode;

import com.bjpowernode.ba03.School;
import com.bjpowernode.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;


/**
 *
 */
public class MyTest03 {



    @Test
    public void test01(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ctx  = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ctx.getBean("myStudent3");

        System.out.println("student="+student);


        //获取File对象
        File file = (File) ctx.getBean("myFile");
        System.out.println("file=="+file.getName());

    }
}
