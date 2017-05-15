package com.cyj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderServiceTest {
    @Resource
    private OrderService orderService;
    @Test
    public void supplyNumberEqualsArriveNumber() throws Exception {
        boolean flag = orderService.SupplyNumberEqualsArriveNumber(16);
        System.out.println(flag);
    }

}