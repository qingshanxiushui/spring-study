package com.bjpowernode;

import com.bjpowernode.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class MyTest {

    @Test
    public void test01(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");

        service.buy(1001, 20);
    }
}
