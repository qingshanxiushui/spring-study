package com.bjpowernode;

import com.bjpowernode.handle.MyAspect;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import java.util.Date;

/**
 *  调用ServiceProxy类方法时候， 调用真正的目标方法，
 *  调用目标方法的时候，增加了一些功能。
 *
 *  ServiceProxy叫做代理， 代理对目标的操作。
 *
 *  创建代理，可以完成对目标方法的调用， 增减功能。
 *  保持目标方法内容不变。
 */
public class ServiceProxy2 implements SomeService {

    //真正的目标
    SomeService target = new SomeServiceImpl();
    MyAspect aspect  = new MyAspect();
    @Override
    public void doSome(String name,Integer age) {

        aspect.myBefore2(null);
        target.doSome("lisi",20);

    }

    @Override
    public void doOther() {

    }


}

