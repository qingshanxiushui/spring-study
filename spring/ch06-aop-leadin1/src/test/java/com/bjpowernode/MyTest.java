package com.bjpowernode;

import com.bjpowernode.proxy.ServiceProxy;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;
import org.junit.Test;

/**
 *
 */
public class MyTest {

    @Test
    public void test01(){
        SomeService service = new SomeServiceImpl();

        service.doSome("lisi",20);

        System.out.println("=============================================");

        service.doOther();
    }

    @Test
    public void test02(){
        SomeService service = new ServiceProxy();

        service.doSome("lisi",20);


    }
}
