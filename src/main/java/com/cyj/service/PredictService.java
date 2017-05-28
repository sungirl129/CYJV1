package com.cyj.service;

import com.cyj.dao.PredictDao;
import com.cyj.model.PredictModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/6.
 */
@Service
public class PredictService {
    @Resource
    private PredictDao predictDao;
    @Resource
    private StockService stockService;

    public int[] predict(String goodsName) {
        int[] plan = new int[12];
        for(int i = 0; i < 12; i++) {
            plan[i] = 0;
            //plan[i] = (int)(1 + Math.random() * (10-1+1));
        }
        int goodsId = stockService.findGoodsIdByGname(goodsName);
        List<PredictModel> predictModelList = predictDao.getPredict(goodsId);
        for(PredictModel predictModel:predictModelList) {
            int num = predictModel.getPlan();
            int month = predictModel.getMonth();
            plan[month - 1] += num;
        }
        return plan;
    }
}
