package com.cyj.service;

import com.cyj.dao.StatisticsDao;
import com.cyj.model.StatisticsModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class StatisticsService {
    @Resource
    private StatisticsDao statisticsDao;

    public boolean insertPurchaseNumber(int goodsId, int purchaseNumber) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        StatisticsModel model = statisticsDao.findModelByGoodsIdAndTime(goodsId, year, month);
        if(model != null) {
            int pNum = model.getPurchaseNumber();
            int id = model.getId();
            purchaseNumber += pNum;
            return (statisticsDao.updatePurchaseNumber(purchaseNumber, id) == 1);
        } else {
            StatisticsModel statisticsModel = new StatisticsModel();
            statisticsModel.setGoodsId(goodsId);
            statisticsModel.setYear(year);
            statisticsModel.setMonth(month);
            statisticsModel.setPurchaseNumber(purchaseNumber);
            statisticsModel.setApplyNumber(0);
            statisticsModel.setState(0);
            return (statisticsDao.insertItem(statisticsModel) == 1);
        }
    }

    public boolean updateInNumber(int inNumber, int goodsId, int year, int month) {
        StatisticsModel model = statisticsDao.findModelByGoodsIdAndTime(goodsId, year, month);
        if(model != null) {
            int id = model.getId();
            int number = model.getApplyNumber();
            inNumber += number;
            return (statisticsDao.updateApplyNumber(inNumber, id) == 1);
        } else {
            StatisticsModel statisticsModel = new StatisticsModel();
            statisticsModel.setGoodsId(goodsId);
            statisticsModel.setYear(year);
            statisticsModel.setMonth(month);
            statisticsModel.setPurchaseNumber(0);
            statisticsModel.setApplyNumber(inNumber);
            statisticsModel.setState(0);
            return (statisticsDao.insertItem(statisticsModel) == 1);
        }
    }

    public int[] statisticsGoodsByYear(int goodsId, int year) {
        int month[] = new int[24];
        for(int i = 0; i < 12; i++) {
            month[i * 2] = month[i * 2 + 1] = 0;
        }
        List<StatisticsModel> statisticsModelList = statisticsDao.getModelsByGidAndYear(goodsId, year);
        for(StatisticsModel statisticsModel:statisticsModelList) {
            int mon = statisticsModel.getMonth();
            int purchaseNumber = statisticsModel.getPurchaseNumber();
            int applyNumber = statisticsModel.getApplyNumber();
            month[(mon - 1) * 2] += purchaseNumber;
            month[(mon - 1) * 2 + 1] += applyNumber;
        }
        return month;
    }
}
