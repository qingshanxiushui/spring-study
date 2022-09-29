package com.bjpowernode.service.impl;

import com.bjpowernode.service.NumberSerivce;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("numberService")
public class NumberServiceImpl implements NumberSerivce {
    @Override
    public Integer addNumber(Integer n1, Integer n2, Integer n3) {
        return n1+n2+n3;
    }
}
