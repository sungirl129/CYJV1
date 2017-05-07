package com.cyj.dao;

import com.cyj.model.PayModel;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface PayDao {
    List<PayModel> viewPayInfoByOrderId(int orderId);
    int insertItem(PayModel payModel);
}
