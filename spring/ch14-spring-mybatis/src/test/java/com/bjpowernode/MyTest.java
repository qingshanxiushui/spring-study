package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 */
public class MyTest {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names [] = ctx.getBeanDefinitionNames();
        for(String name:names){
            System.out.println("容器对象名称="+name+"====对象类型="+ctx.getBean(name));
        }
    }


    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentDao dao  = (StudentDao) ctx.getBean("studentDao");

        Student student  = new Student();
        student.setName("李四");
        student.setAge(20);
        dao.insertStudent(student);
    }

    @Test
    public void test03(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service  = (StudentService) ctx.getBean("studentService");

        Student student  = new Student();
        student.setName("张三");
        student.setAge(22);
        service.addStudent(student);
    }

    @Test
    public void test04(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service  = (StudentService) ctx.getBean("studentService");

        List<Student> list = service.queryStudent();

        for(Student stu:list){
            System.out.println("stu="+stu);
        }
    }

    @Test
    public void test05(){
        File file =  new File("ssss");
        try {
            FileInputStream fileIn = new FileInputStream( file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
