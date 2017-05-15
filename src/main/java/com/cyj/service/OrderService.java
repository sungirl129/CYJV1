package com.cyj.service;

import com.cyj.dao.OrderDao;
import com.cyj.model.*;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/10.
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private ApplicationService applicationService;
    @Resource
    private SupplierService supplierService;
    @Resource
    private PublishService publishService;
    @Resource
    private StockService stockService;
    @Resource
    private ArriveService arriveService;

    public OrderModel findModelById(int id) {
        return orderDao.findModelById(id);
    }

    public boolean insertOrder(OrderModel orderModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        orderModel.setValidDate(timestamp);
        return (orderDao.insertOrder(orderModel) == 1);
    }

    public int getAllOrderNumberByState(int state) {
        List<OrderModel> list = orderDao.getAllOrderByState(state);
        return list.size();
    }

    public PageUtil viewOnePageOrderByState(int pageNum, int pageSize, int state) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = getAllOrderNumberByState(state);
        int offset = (pageNum - 1) * pageSize;
        List<OrderModel> orderModelList = orderDao.getOnePageOrderByState(state, offset, pageSize);
        for(OrderModel orderModel:orderModelList) {
            Map map = new HashMap();
            map.put("orderModel",orderModel);
            int applicationId = orderModel.getApplicationId();
            ApplicationModel applicationModel = applicationService.findModelById(applicationId);
            map.put("applicationModel", applicationModel);
            int supplierId = applicationModel.getSupplierId();
            SupplierModel supplierModel = supplierService.findModelById(supplierId);
            map.put("supplierModel", supplierModel);
            int publishId = applicationModel.getPublishId();
            PublishModel publishModel = publishService.findModelById(publishId);
            int goodsId = publishModel.getGoodsId();
            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
            map.put("goodsModel", goodsModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize, totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    public boolean goodsArriveChangeAcceptNumber(int orderId, int number) {
        OrderModel orderModel = orderDao.findModelById(orderId);
        int acceptNumber = orderModel.getAcceptNumber() + number;
        return (orderDao.updateAcceptNumber(acceptNumber,orderId) == 1);
    }

    public int getApplicationIdByOrderId(int orderId) {
        OrderModel orderModel = orderDao.findModelById(orderId);
        return orderModel.getApplicationId();
    }

    public boolean changePayedMoney(int orderId, double payMoney) {
        OrderModel orderModel = orderDao.findModelById(orderId);
        double payedMoney = orderModel.getPayedMoney();
        payedMoney += payMoney;
        return (orderDao.updatePayedMoney(payedMoney, orderId) == 1);
    }

    public boolean SupplyNumberEqualsArriveNumber(int orderId) {
        OrderModel orderModel = orderDao.findModelById(orderId);
        int acceptNumber = orderModel.getAcceptNumber();
       // System.out.println(acceptNumber);
        int returnedNumber = orderModel.getReturnedNumber();
        System.out.println(returnedNumber);
        int totalArriveNumber = acceptNumber + returnedNumber;
        int applicationId = getApplicationIdByOrderId(orderId);
        ApplicationModel applicationModel = applicationService.findModelById(applicationId);
        int supplyNumber = applicationModel.getSupplyNumber();
       // System.out.println(supplyNumber);
        return (totalArriveNumber == supplyNumber);
    }

    public boolean checkPayedMoney(int orderId) {
        OrderModel orderModel = findModelById(orderId);
        double payedMoney = orderModel.getPayedMoney();
        int acceptNumber = orderModel.getAcceptNumber();
        int applicationId = getApplicationIdByOrderId(orderId);
        ApplicationModel applicationModel = applicationService.findModelById(applicationId);
        double price = applicationModel.getPrice();
        if(Double.compare(payedMoney, acceptNumber * price) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean changeOrderState(int orderId, int state) {
        return (orderDao.updateState(state,orderId) == 1);
    }

    public PageUtil searchMyOrderByCondition(int pageNum, int pageSize, int supplierId, String gname, int state) {
        List<Map<String,Object>> list = new ArrayList<>();
        int goodsId = 0;
        if(gname != null) {
            if(!gname.equals("")) {
                goodsId = stockService.findGoodsIdByGname(gname);
            }
        }
        int totalCount = getMyOrderTotalCountByCondition(supplierId, goodsId, state);
        int offset = (pageNum - 1) * pageSize;
        List<OrderModel> orderModelList = orderDao.getOnePageConditionOrderBySupplierIdandState(supplierId, goodsId, state, offset, pageSize);
        for(OrderModel orderModel:orderModelList) {
            Map<String,Object> map = new HashMap<>();
            int applicationId = orderModel.getApplicationId();
            ApplicationModel applicationModel = applicationService.findModelById(applicationId);
            map.put("orderModel",orderModel);
            map.put("applicationModel",applicationModel);
            int gid = orderModel.getGoodsId();
            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(gid);
            map.put("goodsModel",goodsModel);
            list.add(map);
        }
        PageUtil pageUtil = new PageUtil(pageSize,totalCount);
        pageUtil.setData(list);
        pageUtil.setPageNumber(pageNum);
        return pageUtil;
    }

    public int getMyOrderTotalCountByCondition(int supplierId, int goodsId, int state) {
        List<OrderModel> orderModelList = orderDao.getConditionItemBySupplierIdAndState(supplierId, goodsId, state);
        return orderModelList.size();
    }


    //供货商查看订单
//    public PageUtil viewOnePageMyOrder(int pageNum, int pageSize, int supplierId, int state) {
//        List<Map<String,Object>> list = new ArrayList<>();
//        int totalCount = getMyOrderTotalCount(supplierId, state);
//        int offset = (pageNum - 1) * pageSize;
//        List<OrderModel> orderModelList = orderDao.getOnePageOrderBySupplierIdandState(supplierId, state, offset, pageSize);
//        for(OrderModel orderModel:orderModelList) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("orderModel",orderModel);
//            int applicationId = orderModel.getApplicationId();
//            ApplicationModel applicationModel = applicationService.findModelById(applicationId);
//            map.put("applicationModel",applicationModel);
//            int goodsId = orderModel.getGoodsId();
//            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
//            map.put("goodsModel",goodsModel);
//            list.add(map);
//        }
//        PageUtil pageUtil = new PageUtil(pageSize,totalCount);
//        pageUtil.setData(list);
//        pageUtil.setPageNumber(pageNum);
//        return pageUtil;
//    }


//    public int getMyOrderTotalCount(int supplierId, int state) {
//        List<OrderModel> orderModelList = orderDao.getItemBySupplierIdAndState(supplierId, state);
//        return orderModelList.size();
//    }

    public boolean setReturnedNumber(int returnedNumber, int id) {
        return (orderDao.updateReturnedNumber(returnedNumber, id) == 1);
    }
}
