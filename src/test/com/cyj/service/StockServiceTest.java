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
    @Test
    public void getGoodsStockInfo() throws Exception {
        PageUtil page = stockService.getGoodsStockInfo(2,8);
        List list = page.getData();
        Iterator<Map<String,Object>> iterator = list.iterator();
        System.out.println(list.size());
        while (iterator.hasNext()) {
            Map<String, Object> map = iterator.next();
            GoodsModel model = (GoodsModel)map.get("goodsModel");
            StockModel stockModel = (StockModel)map.get("stockModel");
            System.out.println(model.toString() + "-----" + stockModel.toString());
        }
    }

    @Test
    public void searchGoodsStock() throws Exception {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        List<GoodsModel> totalList = stockDao.searchGoodsByCondition("gname","苹果");
//        int totalCount = totalList.size();
//        System.out.println(totalCount);
//        int offset = (pageNum - 1) * pageSize;
//        List<GoodsModel> goodsModelList = stockDao.searchOnePageGoodsByCondition(offset, pageSize, type, condition);
//        Iterator<GoodsModel> iterator = goodsModelList.iterator();
//        while (iterator.hasNext()) {
//            GoodsModel goodsModel = iterator.next();
//            Map map = new HashMap();
//            int goodsId = goodsModel.getId();
//            map.put("goodsModel",goodsModel);
//            StockModel stockModel = stockDao.findStockModelByGoodsId(goodsId);
//            map.put("stockModel",stockModel);
//            list.add(map);
//        }
//        PageUtil page = new PageUtil(pageSize,totalCount);
//        page.setData(list);
//        page.setPageNumber(pageNum);
//        return page;

    }


}