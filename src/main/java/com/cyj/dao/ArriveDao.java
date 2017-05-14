package com.cyj.dao;

import com.cyj.model.ArriveModel;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface ArriveDao {
    List<ArriveModel> getModelListByOrderId(int orderId);
    int insertArriveItem(ArriveModel arriveModel);
}
