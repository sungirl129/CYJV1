package com.cyj.model.show;

import com.cyj.dao.StockDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;

/**
 * Created by zhuangqf on 5/7/17.
 */
public class Stock {
    private StockModel stockModel;
    private GoodsModel goodsModel;

    public StockModel getStockModel() {
        return stockModel;
    }

    public void setStockModel(StockModel stockModel) {
        this.stockModel = stockModel;
    }

    public GoodsModel getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(GoodsModel goodsModel) {
        this.goodsModel = goodsModel;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockModel=" + stockModel +
                ", goodsModel=" + goodsModel +
                '}';
    }
}
