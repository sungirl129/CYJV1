package com.cyj.service;

import com.cyj.dao.StockDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import com.cyj.model.show.Stock;
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

    public List<Stock> search(String gname,String unit,int stockL,int stockR){
        return stockDao.search(unit,gname,stockL,stockR);
    }

}
