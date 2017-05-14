package com.cyj.service;

import com.cyj.dao.ExchangeDao;
import com.cyj.model.ExchangeModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/14.
 */
@Service
public class ExchangeService {
    @Resource
    private ExchangeDao exchangeDao;

    public boolean insertItem(ExchangeModel exchangeModel) {
        return (exchangeDao.insertItem(exchangeModel) == 1);
    }
    public boolean insertItem(int orderId, int arriveId, int changeNum) {
        ExchangeModel exchangeModel = new ExchangeModel();
        exchangeModel.setOrderId(orderId);
        exchangeModel.setArriveId(arriveId);
        exchangeModel.setExchangeNumber(changeNum);
        return  insertItem(exchangeModel);
    }
}
