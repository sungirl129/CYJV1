package com.cyj.dao;

import com.cyj.model.StatisticsModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface StatisticsDao {
    StatisticsModel findModelById(int id);
    int insertItem(StatisticsModel model);
    int updatePurchaseNumber(@Param("purchaseNumber")int purchaseNumber, @Param("id")int id);
    int updateApplyNumber(@Param("applyNumber")int applyNumber, @Param("id")int id);
    StatisticsModel findModelByGoodsIdAndTime(@Param("gid") int gid, @Param("year") int year, @Param("month") int month);
    List<StatisticsModel> getModelsByGidAndYear(@Param("gid") int gid, @Param("year") int year);
}
