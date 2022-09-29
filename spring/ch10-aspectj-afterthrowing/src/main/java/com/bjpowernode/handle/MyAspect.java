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
       异常通知方法的定义
       1）方法是public
       2）方法是没有返回值。是void
       3）方法名称自定义
       4）方法有参数是Exception
     */

    /**
     * @AfterThrowing:异常通知
     *     属性： value 切入点表达式
     *           throwing 自定义变量，表示目标方法抛出的异常。
     *                    变量名必须和通知方法的形参名一样
     *     位置：在方法的上面
     * 特点：
     *  1. 在目标方法抛出异常后执行的， 没有异常不执行
     *  2. 能获取到目标方法的异常信息。
     *  3. 不是异常处理程序。可以得到发生异常的通知， 可以发送邮件，短信通知开发人员。
     *      看做是目标方法的监控程序。
     *
     *  异常通知的执行
     *  try{
     *      SomeServiceImpl.doSecond(..)
     *  }catch(Exceptoin e){
     *      myAfterThrowing(e);
     *  }
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Exception ex){
        System.out.println("异常通知，在目标方法抛出异常时执行的，异常原因是："+ex.getMessage());
        /*
           异常发生可以做：
           1.记录异常的时间，位置，等信息。
           2.发送邮件，短信，通知开发人员
         */
    }



}
