package com.bjpowernode.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 */
@Aspect
@Component
public class CheckArgumentAspect {

    @Around(value = "execution(* *..NumberServiceImpl.addNumber(..))")
    public Object checkArgument(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("执行了环绕通知checkArgument");

        boolean isAll = true;//true表示参数正确的

        //获取执行addNumber方法时的实参
        Object args [] = pjp.getArgs();
        for(Object arg:args){
            if( arg == null){
                //参数是null， 不正确。
                isAll = false;
                break;
            } else {
                // 参数不为null
                Integer temp = (Integer)arg;
                if( temp.intValue() <=0 ){
                    isAll = false;
                    break;
                }
            }
        }

        // 根据参数检查的结果，决定是否执行目标方法
        Object res = null;
        if( isAll ){
            //调用目标方法
            res = pjp.proceed();
        } else {
            //参数检查不正确
            res  = -1;
        }
        return res;
    }
}
