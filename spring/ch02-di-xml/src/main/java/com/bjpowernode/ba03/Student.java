package com.bjpowernode.ba03;

/**
 *
 */
public class Student {

    private String name;
    private int age;
    //引用类型
    private School school;


    public Student() {
        System.out.println("Student无参数构造方法");
    }

    //创建有参数构造方法
    public Student(String myname,int myage, School mySchool){
        System.out.println("Student有参数构造方法");
        //给属性依次赋值
        this.name = myname;
        this.age = myage;
        this.school = mySchool;
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
