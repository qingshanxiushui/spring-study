package com.bjpowernode.ba01;

/**
 *
 */
public class Student {

    private String name;
    private int age;

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

    public void setEmail(String email){
        //email属性  <property name="email" value="lisi@qq.com" />
        System.out.println("setEmail==="+email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
