package com.bjpowernode.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")
public class Student {


    @Value("${myname}")
    private String name ;
    @Value("${myage}")
    private int age;

    /**
     * 引用类型
     * @Autowired: spring框架提供的，给引用类型赋值的，使用自动注入原理。
     *             支持byName，byType。默认是byType.
     *
     *        属性：required ：boolean类型的属性， 默认true
     *             true：spring在启动的时候，创建容器对象时候，会检查引用类型是否赋值成功。
     *                   如果赋值失败， 终止程序执行，并报错。
     *             false：引用类型赋值失败，程序正常执行，不报错。引用类型的值是null
     *
     *       位置：1)在属性定义的上面，无需set方法，推荐使用
     *            2）在set方法的上面
     *
     * byName自动注入：
     * 1)@Autowired:给引用类型赋值
     * 2)@Qualifer(value="bean的id")：从容器中找到指定名称的对象，
     *                                把这个对象赋值给引用类型。
     */
    //byName
    @Autowired(required = false)
    @Qualifier("mySchoolAAAAA")
    private School school;

    public Student() {
        System.out.println("Student无参数构造方法");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
