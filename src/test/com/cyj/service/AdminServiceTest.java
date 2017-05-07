package com.cyj.service;

import com.cyj.model.AdminModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminServiceTest {
    @Resource private AdminService adminService;
    @Test
    public void findAdminById() throws Exception {
        for(int i=1;i<=2;i++){
            AdminModel admin = adminService.findAdminById(i);
            System.out.println(admin.toString());
        }
    }

    @Test
    public void adminValid() {
        boolean flag = adminService.adminValid("1","1");
        System.out.println(flag);
    }

}