package com.cyj.service;

import com.cyj.dao.StockDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import com.cyj.tools.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StockServiceTest {
    @Resource
    private StockService stockService;
    @Resource
    private StockDao stockDao;


}