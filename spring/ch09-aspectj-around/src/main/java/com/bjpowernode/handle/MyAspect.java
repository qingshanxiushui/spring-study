package com.bjpowernode.handle;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
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
       环绕置通知方法的定义
       1）方法是public
       2）方法是必须有返回值， 推荐使用Object类型
       3）方法名称自定义
       4）方法必须有ProceedingJoinPoint参数，
     */

    /**
     * @Around：环绕通知
     *    属性：value 切入点表达式
     *    位置：在方法定义的上面
     *
     * 返回值：Object ，表示调用目标方法希望得到执行结果（不一定是目标方法自己的返回值）
     * 参数：  ProceedingJoinPoint, 相当于反射中 Method。
     *        作用：执行目标方法的，等于Method.invoke()
     *
     *        public interface ProceedingJoinPoint extends JoinPoint {}
     *
     * 特点：
     *  1.在目标方法的前和后都能增强功能
     *  2.控制目标方法是否执行
     *  3.修改目标方法的执行结果。
     */
    @Around("execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        //获取方法执行时的参数值
        String name = "";
        Object args [] = pjp.getArgs();
        if( args != null && args.length > 0){
            Object arg = args[0];
            if(arg !=null){
                name=(String)arg;
            }
        }

        Object methodReturn = null;

        System.out.println("执行了环绕通知，在目标方法之前，输出日志时间=="+ new Date());
        //执行目标方法  ProceedingJoinPoint，表示doFirst

        if("lisi".equals(name)){
            methodReturn = pjp.proceed();//method.invoke(),表示执行doFirst()方法本身
        }

        if( methodReturn != null){
            methodReturn ="环绕通知中，修改目标方法原来的执行结果";
        }

        System.out.println("环绕通知，在目标方法之后，增加了事务提交功能");

        //return "HelloAround,不是目标方法的执行结果";
        //返回目标方法执行结果。没有修改的。
        return methodReturn;

    }


}
