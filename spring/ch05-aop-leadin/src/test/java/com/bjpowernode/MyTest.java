package com.bjpowernode;

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

        service.doSome();

        System.out.println("=============================================");

        service.doOther();
    }
}
