package com.cyj.service;

import com.cyj.dao.ApplicationDao;
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
public class ApplicationService {
    @Resource
    private ApplicationDao applicationDao;
    @Resource
    private StockService stockService;
    @Resource
    private PublishService publishService;
    @Resource
    private SupplierService supplierService;
    @Resource
    private OrderService orderService;

    public ApplicationModel findModelById(int id) {
        return applicationDao.findModelById(id);
    }

    public int getApplicationTotalCountByValidAndState(int valid, int state) {
        List<ApplicationModel> applicationModelList = applicationDao.getApplicationTotalCountByValidAndState(valid, state);
        return applicationModelList.size();
    }

    public PageUtil viewApplicationInfo(int valid, int state, int pageNum, int pageSize) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = getApplicationTotalCountByValidAndState(valid,state);
        int offset = (pageNum - 1) * pageSize;
        List<ApplicationModel> applicationModelList = applicationDao.getOnePageUncheckedApplication(valid, state, offset, pageSize);
        for(ApplicationModel applicationModel:applicationModelList) {
            Map map = new HashMap();
            map.put("applicationModel", applicationModel);
            int publishId = applicationModel.getPublishId();
            int supplierId = applicationModel.getSupplierId();
            PublishModel publishModel = publishService.findModelById(publishId);
            int goodsId = publishModel.getGoodsId();
            map.put("publishModel",publishModel);
            SupplierModel supplierModel = supplierService.findModelById(supplierId);
            map.put("supplierModel",supplierModel);
            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
            map.put("goodsModel",goodsModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize, totalCount);
        page.setPageNumber(pageNum);
        page.setData(list);
        return page;
    }

    public boolean applicationAccess(int applicationId) {
        return (applicationDao.setValid(1, applicationId) == 1);
    }

    public boolean applicationDeny(int applicationId) {
        return (applicationDao.setValid(2, applicationId) == 1);
    }

    public int getPublishIdById(int applicationId) {
        ApplicationModel applicationModel = applicationDao.findModelById(applicationId);
        return applicationModel.getPublishId();
    }

    public boolean insertItem(ApplicationModel model) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        model.setApplicationDate(timestamp);
        return (applicationDao.insertItem(model) == 1);
    }

    public int viewMyTotalCountByState(int supplierId, int state) {
        List<ApplicationModel> list = applicationDao.viewMyApplicationByState(supplierId, state);
        return list.size();
    }

    public int viewMyTotalCountByStateValid(int supplierId, int state, int valid) {
        List<ApplicationModel> list = applicationDao.viewMyApplicationByStateValid(supplierId, state, valid);
        return list.size();
    }

    //供货商查看自己的申请单
    public PageUtil viewMyApplication(int pageNum, int pageSize, int supplierId) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = viewMyTotalCountByState(supplierId, 0);
        int offset = (pageNum - 1) * pageSize;
        List<ApplicationModel> applicationModelList = applicationDao.viewOnePageMyApplicationByState(supplierId, 0, offset, pageSize);
        //System.out.println("OnePageSize:=============" + applicationModelList.size());
        for(ApplicationModel applicationModel: applicationModelList) {
            int valid = applicationModel.getValid();
            switch (valid) {
                case 0:
                    applicationModel.setStrValid("暂未审批");
                    break;
                case 1:
                    applicationModel.setStrValid("审批通过");
                    break;
                case 2:
                    applicationModel.setStrValid("不通过");
                    break;
                default:break;
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("applicationModel", applicationModel);
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

    //供货商查看自己的申请单
    public PageUtil viewMyApplicationByValid(int pageNum, int pageSize, int supplierId, int valid) {
        List<Map<String, Object>> list = new ArrayList<>();
        int totalCount = viewMyTotalCountByStateValid(supplierId, 0, valid);
        int offset = (pageNum - 1) * pageSize;
        List<ApplicationModel> applicationModelList = applicationDao.viewOnePageMyApplicationByValid(supplierId, valid, offset, pageSize);
        for(ApplicationModel applicationModel: applicationModelList) {
            switch (valid) {
                case 0:
                    applicationModel.setStrValid("暂未审批");
                    break;
                case 1:
                    applicationModel.setStrValid("审批通过");
                    break;
                case 2:
                    applicationModel.setStrValid("不通过");
                    break;
                default:
                    break;
            }
            Map<String,Object> map = new HashMap<>();
            map.put("applicationModel", applicationModel);
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
}
