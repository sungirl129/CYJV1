package com.cyj.service;

import com.cyj.dao.StockDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/4/5.
 */
@Service
public class StockService {
    @Resource
    private StockDao stockDao;

    //得到货物类别数量
    public int getTotalGoodsNumber() {
        List<GoodsModel> TotalList = stockDao.getStockTotalItem();
        int totalCount = TotalList.size();
        return totalCount;
    }

    //显示一页货物信息
    public List<GoodsModel> getOnePageGoodsInfo(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return stockDao.getOnePageGoodsInfo(offset, pageSize);
    }

    public StockModel findStockModelByGoodsId(int id) {
        return stockDao.findStockModelByGoodsId(id);
    }

    public GoodsModel findGoodsModelByGoodsId(int id) {
        return stockDao.findGoodsModelByGoodsId(id);
    }

    public int findGoodsIdByGname(String name) {
        GoodsModel goodsModel = stockDao.findGoodsModelByGname(name);
        return goodsModel.getId();
    }
    /*
    //查看库存信息
     */
    public PageUtil getGoodsStockInfo(int pageNum, int pageSize) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = getTotalGoodsNumber();
        int offset = (pageNum - 1) * pageSize;
        List<GoodsModel> goodsModelList = stockDao.getOnePageGoodsInfo(offset, pageSize);
        Iterator<GoodsModel> iterator = goodsModelList.iterator();
        while (iterator.hasNext()) {
            GoodsModel goodsModel = iterator.next();
            Map map = new HashMap();
            map.put("goodsModel",goodsModel);
            int goodsId = goodsModel.getId();
            StockModel stockModel = stockDao.findStockModelByGoodsId(goodsId);
            map.put("stockModel",stockModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize,totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }


    /*
    //根据货物名称查询货物信息及库存信息
     */
    public PageUtil searchGoodsStockByGname(int pageNum, int pageSize, String condition) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<GoodsModel> totalList = stockDao.searchGoodsByGnameCondition(condition);
        int totalCount = totalList.size();
        int offset = (pageNum - 1) * pageSize;
        List<GoodsModel> goodsModelList = stockDao.searchOnePageGoodsByGnameCondition(offset, pageSize, condition);
        Iterator<GoodsModel> iterator = goodsModelList.iterator();
        while (iterator.hasNext()) {
            GoodsModel goodsModel = iterator.next();
            Map map = new HashMap();
            int goodsId = goodsModel.getId();
            map.put("goodsModel",goodsModel);
            StockModel stockModel = stockDao.findStockModelByGoodsId(goodsId);
            map.put("stockModel",stockModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize,totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    public PageUtil searchGoodsStockByGnameAndStock(int pageNum, int pageSize, String condition, int stockL, int stockR) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<GoodsModel> totalList = stockDao.searchGoodsByGnameCondition(condition);
        int totalCount = 0;
        int index = 0;
        int pageLeft = (pageNum - 1) * pageSize;
        int pageRight = pageNum * pageSize;
        for(GoodsModel goodsModel:totalList) {
            int goodsId = goodsModel.getId();
            StockModel stockModel = findStockModelByGoodsId(goodsId);
            if(stockModel.getNowNumber() >= stockL && stockModel.getNowNumber() <= stockR) {
                totalCount++;
                index++;
                if(index > pageLeft && index <= pageRight) {
                    Map map = new HashMap();
                    map.put("goodsModel",goodsModel);
                    map.put("stockModel",stockModel);
                    list.add(map);
                }
            }
        }
        PageUtil page = new PageUtil(pageSize,totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }


    public PageUtil searchGoodsStockByUnit(int pageNum, int pageSize, String condition) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<GoodsModel> totalList = stockDao.searchGoodsByUnitCondition(condition);
        int totalCount = totalList.size();
        int offset = (pageNum - 1) * pageSize;
        List<GoodsModel> goodsModelList = stockDao.searchOnePageGoodsByUnitCondition(offset, pageSize, condition);
        for(GoodsModel goodsModel:goodsModelList) {
            Map map = new HashMap();
            int goodsId = goodsModel.getId();
            map.put("goodsModel",goodsModel);
            StockModel stockModel = stockDao.findStockModelByGoodsId(goodsId);
            map.put("stockModel",stockModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize,totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    public PageUtil searchGoodsStockByUnitAndStock(int pageNum, int pageSize, String condition, int stockL, int stockR) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<GoodsModel> totalList = stockDao.searchGoodsByUnitCondition(condition);
        int totalCount = 0;
        int index = 0;
        int pageLeft = (pageNum - 1) * pageSize;
        int pageRight = pageNum * pageSize;
        for(GoodsModel goodsModel:totalList) {
            int goodsId = goodsModel.getId();
            StockModel stockModel = findStockModelByGoodsId(goodsId);
            if(stockModel.getNowNumber() >= stockL && stockModel.getNowNumber() <= stockR) {
                index++;
                totalCount++;
                if(index > pageLeft && index <= pageRight) {
                    Map map = new HashMap();
                    map.put("stockModel",stockModel);
                    map.put("goodsModel",goodsModel);
                    list.add(map);
                }
            }
        }
        PageUtil page = new PageUtil(pageSize,totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }
}
