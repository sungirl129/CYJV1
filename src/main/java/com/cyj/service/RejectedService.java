package com.cyj.service;

import com.cyj.dao.RejectedDao;
import com.cyj.model.RejectedModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/11.
 */
@Service
public class RejectedService {
    @Resource
    private RejectedDao rejectedDao;

    public boolean insertItem(RejectedModel rejectedModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        rejectedModel.setReturnedDate(timestamp);
        return (rejectedDao.insertItem(rejectedModel) == 1);
    }
    public boolean insertItem(int orderId, int returnedNumber) {
        RejectedModel rejectedModel = new RejectedModel();
        rejectedModel.setArriveId(orderId);
        rejectedModel.setReturnedQuantity(returnedNumber);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        rejectedModel.setReturnedDate(timestamp);
        return insertItem(rejectedModel);
    }

}
