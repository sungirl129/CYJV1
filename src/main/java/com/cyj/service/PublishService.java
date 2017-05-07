package com.cyj.service;

import com.cyj.dao.PublishDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.PublishModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/8.
 */
@Service
public class PublishService {
    @Resource
    private PublishDao publishDao;
    @Resource
    private StockService stockService;

    public PublishModel findModelById(int publishId) {
        return publishDao.findModelById(publishId);
    }

    //发布计划，插入或者修改publish记录
    public boolean publishSchedule(PublishModel publishModel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        publishModel.setPublishDate(timestamp);
        int goodsId = publishModel.getGoodsId();
        PublishModel model = getPublishModelByGoodsId(goodsId);
        int i = 0;
        if(model != null) {
            //已有此货物的发布信息，修改
            model.setPublishNumber(model.getPublishNumber() + publishModel.getPublishNumber());
            model.setPublishDate(timestamp);
            i = publishDao.changePublishNumber(model);
        } else {
            //不存在，插入信息
            i = publishDao.insertPublishItem(publishModel);
        }
        return (i == 1);
    }

    public boolean deleteItem(int id) {
        return (publishDao.deleteItem(id) == 1);
    }

    public PublishModel getPublishModelByGoodsId(int id) {
        return publishDao.getPublishModelByGoodsId(id);
    }

    public int getPublishTotalCountByState(int state) {
        List<PublishModel> publishModels = publishDao.getPublishTotalCountByState(state);
        int totalCount = publishModels.size();
        return totalCount;
    }

    public PageUtil getOnePagePublishInfo(int pageNum, int pageSize, int state) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = getPublishTotalCountByState(state);
        int offset = (pageNum - 1) * pageSize;
        List<PublishModel> publishModelList = publishDao.getOnePagePublishByState(state, offset, pageSize);
        for(PublishModel publishModel:publishModelList){
            Map map = new HashMap();
            int goodsId = publishModel.getGoodsId();
            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
            map.put("publishModel", publishModel);
            map.put("goodsModel",goodsModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize, totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    public boolean cacelPublish(int pid) {
        return (publishDao.cacelPublish(pid) == 1);
    }

    public boolean changePublishState(int pid, int state) {
        return (publishDao.changeState(state, pid) == 1);
    }


    public boolean changeApplyNumber(int applyNumber, int id) {
        PublishModel publishModel = findModelById(id);
        int publishNumber = publishModel.getPublishNumber();
        int i = publishDao.changeApplyNumber(applyNumber, id);
        int j = 1;
        if(publishNumber > applyNumber)
            j = publishDao.changeState(0,id);
        else
            j = publishDao.changeState(1,id);
        return (i == 1 && j == 1);
    }

    public boolean addApplyNumber(int applyNumber, int id) {
        PublishModel publishModel = findModelById(id);
        int number = publishModel.getApplyNumber();
        applyNumber += number;
        return changeApplyNumber(applyNumber, id);
    }

    public boolean returnGoodsChangePulish(int publishId, int returnedNum) {
        PublishModel publishModel = publishDao.findModelById(publishId);
        int applyNumber = publishModel.getApplyNumber();
        applyNumber -= returnedNum;
        return changeApplyNumber(applyNumber, publishId);
    }


    public int[] viewRateByGnameYear(int goodsId, int year) {
        int season[] = new int[4];
        return season;
    }

}















