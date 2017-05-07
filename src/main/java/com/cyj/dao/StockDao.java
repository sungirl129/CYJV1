package com.cyj.dao;

import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
public interface StockDao {
    List<GoodsModel> getStockTotalItem();
    List<GoodsModel> getOnePageGoodsInfo(@Param("offset") int offset, @Param("pageSize") int pageSize);
    List<GoodsModel> searchGoodsByGnameCondition(String condition);
    List<GoodsModel> searchGoodsByUnitCondition(String condition);
    List<GoodsModel> searchOnePageGoodsByGnameCondition(@Param("offset") int offset, @Param("pageSize") int pageSize,  @Param("condition") String condition);
    List<GoodsModel> searchOnePageGoodsByUnitCondition(@Param("offset") int offset, @Param("pageSize") int pageSize,  @Param("condition") String condition);
    StockModel findStockModelByGoodsId(int id);
    GoodsModel findGoodsModelByGoodsId(int id);
    GoodsModel findGoodsModelByGname(String name);
}
