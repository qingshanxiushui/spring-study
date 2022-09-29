package com.bjpowernode.handle;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
       后置通知方法的定义
       1）方法是public
       2）方法是void
       3）方法名称自定义
       4）方法有参数，推荐使用Object类型。
     */

    /**
     * @AfterReturning:后置通知
     *    属性：value 切入点表达式
     *          returning 自定义的变量，表示目标方法的返回值的。
     *                    自定义变量名称必须和通知方法的形参名一样
     *    位置：在方法的上面
     *
     * 特点：
     *  1.在目标方法之后，执行的。
     *  2.能获取到目标方法的执行结果。
     *  3.不会影响目标方法的执行
     *
     * 方法的参数：
     *   Object res： 表示目标方法的返回值，使用res接收doOther的调用结果。
     *   Object res= doOther();
     *
     *  后置通知的执行顺序
     *  Object res = SomeServiceImpl.doOther(..); Student
     *
     *  myAfterReturning(res);
     *
     *  思考：
     *    1 doOther方法返回是String ，Integer ，Long等基本类型，
     *      在后置通知中，修改返回值， 是不会影响目标方法的最后调用结果的。
     *    2 doOther返回的结果是对象类型，例如Student。
     *      在后置通知方法中，修改这个Student对象的属性值，会不会影响最后调用结果？
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",
                    returning = "res")
    public void myAfterReturning(JoinPoint jp, Object res){

        //修改目标方法的返回值
        if(res != null){
            res = "HELLO Aspectj";
        }
        System.out.println("后置通知，在目标方法之后，执行的。能拿到执行结果："+res);
        //Object res有什么用
//        if("abcd".equals(res)){
//            System.out.println("根据返回值的不同，做不同的增强功能");
//        } else if("add".equals(res)){
//            System.out.println("doOther做了添加数据库， 我做了备份数据");
//        }


    }

}
