package com.cyj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ScheduleServiceTest {
    @Resource
    private ScheduleService scheduleService;
    @Test
    public void viewScheduleByGnameYear() throws Exception {
//      //  int[] num = scheduleService.viewScheduleByGnameYear(4,2017);
//        for(int i = 0; i < 12; i++) {
//            System.out.println(num[i]);
//        }
    }

}