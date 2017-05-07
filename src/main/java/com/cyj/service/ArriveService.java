package com.cyj.service;

import com.cyj.dao.ArriveDao;
import com.cyj.model.ArriveModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Service
public class ArriveService {
    @Resource
    private ArriveDao arriveDao;

    public PageUtil viewArriveInfoByOrderId(int orderId) {
        List<ArriveModel> list = arriveDao.getModelListByOrderId(orderId);
        int totalCount = list.size();
        PageUtil page = new PageUtil(100, totalCount);
        page.setData(list);
        page.setPageNumber(1);
        return page;
    }

    public boolean insertArriveItem(ArriveModel arriveModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        arriveModel.setArriveDate(timestamp);
        return (arriveDao.insertArriveItem(arriveModel) == 1);
    }

    public int getTotalArriveNumberByOrderId(int orderId) {
        int arriveNumber = 0;
        List<ArriveModel> list = arriveDao.getModelListByOrderId(orderId);
        for(ArriveModel arriveModel:list) {
            arriveNumber += arriveModel.getArriveNumber();
        }
        return arriveNumber;
    }
}
