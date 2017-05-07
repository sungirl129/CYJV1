package com.cyj.service;

import com.cyj.dao.PayDao;
import com.cyj.model.PayModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Service
public class PayService {
    @Resource
    private PayDao payDao;

    public PageUtil viewPayInfoByOrderId(int orderId) {
        List<PayModel> list = payDao.viewPayInfoByOrderId(orderId);
        int totalCount = list.size();
        PageUtil page = new PageUtil(100, totalCount);
        page.setData(list);
        page.setPageNumber(1);
        return page;
    }

    public boolean insetPayItem(PayModel payModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        payModel.setPayDate(timestamp);
        return (payDao.insertItem(payModel) == 1);
    }
}
