package com.bjpowernode.ba05;

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


    public void setName(String name) {
        System.out.println("setName==="+name);
        this.name = "Hello:"+name;
    }


    public void setAge(int age) {
        System.out.println("setAge=="+age);
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("setSchool="+school);
        this.school = school;
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
