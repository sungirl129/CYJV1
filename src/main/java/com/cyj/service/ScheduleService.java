package com.cyj.service;

import com.cyj.dao.ScheduleDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.ScheduleModel;
import com.cyj.tools.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Administrator on 2017/4/8.
 */
@Service
public class ScheduleService {
    @Resource
    private ScheduleDao scheduleDao;
    @Resource
    private StockService stockService;

    public ScheduleModel findModelById(int id) {
        return scheduleDao.findModelById(id);
    }

    //根据goods_id得到未发布的采购计划
    public ScheduleModel getUnpublishedModelByGoodsId(int goodsId) {
        return scheduleDao.getUnpublishedModelByGoodsId(goodsId);
    }

    //加入计划
    public boolean addBuyNumber(int buyNumber, Timestamp timestamp, ScheduleModel model) {
        ScheduleModel scheduleModel = scheduleDao.findModelById(model.getId());
        int number = scheduleModel.getBuyNumber();
        buyNumber += number;
        return (scheduleDao.updateBuyNumber(buyNumber,timestamp,model.getId())==1);
    }

    //插入计划表
    public boolean insertSchedule(int goodsId, int buyNumber, Timestamp time) {
        ScheduleModel model = new ScheduleModel();
        model.setGoodsId(goodsId);
        model.setBuyNumber(buyNumber);
        model.setIsPublish(0);
        model.setScheduleState(0);
        model.setScheduleDate(time);
        return (scheduleDao.insertScheduleModel(model)==1);
    }

    //得到未发布的scheduele的总数
    public int getUnpublishScheduleTotalCount(int isPublish, int state) {
        List<ScheduleModel> list = scheduleDao.getUnpublishScheduleTotalCount(isPublish, state);
        int totalCount = list.size();
        return totalCount;
    }

    public PageUtil getOnePageValidUnpublish(int isPublish, int state, int pageNum, int pageSize) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        int totalCount = getUnpublishScheduleTotalCount(isPublish, state);
        int offset = (pageNum - 1) * pageSize;
        List<ScheduleModel> scheduleModelList = scheduleDao.getOnePageUnpublish(isPublish, state,offset,pageSize);
        Iterator<ScheduleModel> iterator = scheduleModelList.iterator();
        while (iterator.hasNext()) {
            Map map = new HashMap();
            ScheduleModel scheduleModel = iterator.next();
            map.put("scheduleModel",scheduleModel);
            int goodsId = scheduleModel.getGoodsId();
            GoodsModel goodsModel = stockService.findGoodsModelByGoodsId(goodsId);
            map.put("goodsModel",goodsModel);
            list.add(map);
        }
        PageUtil page = new PageUtil(pageSize, totalCount);
        page.setData(list);
        page.setPageNumber(pageNum);
        return page;
    }

    //发布计划修改表信息
    public boolean publishChangeScheduleState(int scheduleId) {
        return (scheduleDao.publishChangeScheduleState(scheduleId) == 1);
    }

    public boolean addPublishDate(int scheduleId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return (scheduleDao.addPublishDate(timestamp, scheduleId) == 1);
    }

    //计划单修改buy_number
    public boolean changeBuyNumber(int buyNum, int planId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return (scheduleDao.updateBuyNumber(buyNum,timestamp,planId) == 1);
    }

    //取消发布
    public boolean cancelPublish(int scheduleId) {
        return (scheduleDao.cancelPublish(scheduleId) == 1);
    }

//    public int[] viewScheduleByGnameYear(int goodsId, int year) {
//        int num[] = new int[12];
//        for(int i = 0; i < 12; i++) {
//            num[i] = 0;
//        }
//        List<ScheduleModel> list = scheduleDao.viewScheduleByGnameYear(goodsId, year);
//        for(ScheduleModel scheduleModel:list) {
//            Timestamp time = scheduleModel.getScheduleDate();
//            int month = time.getMonth();
//            int number = scheduleModel.getBuyNumber();
//            num[month] += number;
//        }
//        return num;
//    }
}











