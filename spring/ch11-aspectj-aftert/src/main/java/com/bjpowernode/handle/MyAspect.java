package com.bjpowernode.handle;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.SQLOutput;
import java.util.Date;

/**
 *  @Aspect: 切面类的注解。
 *     位置：放在某个类的上面
 *     作用：表示当前类是切面类。
 *
 *     切面类：表示切面功能的类
 *
 */
@Aspect
public class MyAspect {
    //定义方法，表示切面的具体功能
    /*
       最终通知方法的定义
       1）方法是public
       2）方法是没有返回值。是void
       3）方法名称自定义
       4）方法没有参数
     */


    /**
     * @After：最终通知
     *    属性： value 切入点表达式
     *    位置： 在方法的上面
     * 特点：
     *  1. 在目标方法之后执行的。
     *  2. 总是会被执行。
     *  3. 可以用来做程序最后的收尾工作。例如清除临时数据，变量。 清理内存
     *
     *  最终通知
     *  try{
     *      SomeServiceImpl.doThird(..)
     *  }finally{
     *      myAfter()
     *  }
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("最终通知，总是会被执行的");
    }


}
