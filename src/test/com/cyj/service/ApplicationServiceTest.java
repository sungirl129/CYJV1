package com.cyj.service;

import com.cyj.model.GoodsModel;
import com.cyj.tools.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ApplicationServiceTest {
    @Resource
    private ApplicationService applicationService;
    @Test
    public void viewMyApplication() throws Exception {
        PageUtil nowPage = applicationService.viewMyApplication(1, 4, 7);
        nowPage.setRowNum(4);
        List list = nowPage.getData();
        for(int i = 0; i < list.size(); i++) {
            List sublist = (List)list.get(i);
            System.out.println("sublist:=================");
            System.out.println(sublist.size());
            for(int j = 0; j < sublist.size(); j++) {
                Map map = (Map)sublist.get(j);
                GoodsModel goodsModel = (GoodsModel)map.get("goodsModel");
                System.out.println(goodsModel.toString());
            }
        }
        System.out.println(list.size());

    }

}