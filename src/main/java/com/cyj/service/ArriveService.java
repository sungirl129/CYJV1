package com.cyj.service;

import com.cyj.dao.ArriveDao;
import com.cyj.model.ArriveModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        List<ArriveModel> arriveModelList = new ArrayList<>();
        for(ArriveModel arriveModel:list) {
            int goodsState = arriveModel.getGoodsState();
            if(goodsState == 1) {
                arriveModel.setStrGoodsState("全部合格");
            } else {
                arriveModel.setStrGoodsState("不合格");
            }
            int processWay = arriveModel.getProcessWay();
            switch (processWay)
            {
                case 1:
                    arriveModel.setStrProcessWay("换货");
                    break;
                case 2:
                    arriveModel.setStrProcessWay("退货");
                    break;
                case 3:
                    arriveModel.setStrProcessWay("退换货");
                    break;
            }
            arriveModel.setReturnedNumber(arriveModel.getBadNumber() - arriveModel.getExchangeNumber());
            arriveModelList.add(arriveModel);
        }
        int totalCount = list.size();
        PageUtil page = new PageUtil(100, totalCount);
        page.setData(arriveModelList);
        page.setPageNumber(1);
        return page;
    }

    public boolean insertArriveItem(ArriveModel arriveModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        arriveModel.setArriveDate(timestamp);
        return (arriveDao.insertArriveItem(arriveModel) == 1);
    }

}
