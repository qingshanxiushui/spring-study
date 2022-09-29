package com.bjpowernode.service.impl;

import com.bjpowernode.service.SomeService;

import java.util.Date;

/**
 *
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        System.out.println("业务方法doSome,计算商品购买金额");
    }

    @Override
    public void doOther() {
        System.out.println("业务方法doOther，消减库存");
    }


}