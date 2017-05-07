package com.cyj.service;

import com.cyj.model.GoodsModel;
import com.cyj.model.PublishModel;
import com.cyj.model.ScheduleModel;
import com.cyj.model.StockModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/4/8.
 */
@Service
public class MakePlanService {
    @Resource
    private StockService stockService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private PublishService publishService;

    //查看库存信息
    public PageUtil getGoodsStockInfo(int pageNum, int pageSize) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = stockService.getTotalGoodsNumber();
        List<GoodsModel> goodsModelList = stockService.getOnePageGoodsInfo(pageNum, pageSize);
        Iterator<GoodsModel> iterator = goodsModelList.iterator();
        while (iterator.hasNext()) {
            GoodsModel goodsModel = iterator.next();
            Map map = new HashMap();
            map.put("goodsModel", goodsModel);
            int goodsId = goodsModel.getId();
            StockModel stockModel = stockService.findStockModelByGoodsId(goodsId);
            map.put("stockModel", stockModel);
            ScheduleModel scheduleModel = scheduleService.getUnpublishedModelByGoodsId(goodsId);
            map.put("scheduleModel", scheduleModel);
            PublishModel publishModel = publishService.getPublishModelByGoodsId(goodsId);
            map.put("publishModel", publishModel);
            list.add(map);
        }
        PageUtil  page = new PageUtil(pageSize, totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }
}
