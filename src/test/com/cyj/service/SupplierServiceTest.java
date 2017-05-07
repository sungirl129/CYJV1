package com.cyj.service;

import com.cyj.model.SupplierModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SupplierServiceTest {
    @Resource
    private SupplierService supplierService;

    @Test
    public void insertSupplier() throws Exception {
        SupplierModel model = new SupplierModel();
        model.setCorporation("1");
        model.setAddress("js1");
        model.setName("cyj1");
        model.setTel("111");
        model.setEmail("111@1.com");
        model.setUsername("1");
        model.setPassword("1");
        model.setCredit(1);
        boolean flag = supplierService.insertSupplier(model);
        System.out.println(flag);
    }

}