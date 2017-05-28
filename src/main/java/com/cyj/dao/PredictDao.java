package com.cyj.dao;

import com.cyj.model.PredictModel;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */
public interface PredictDao {
    List<PredictModel> getPredict(int goodsId);
}
