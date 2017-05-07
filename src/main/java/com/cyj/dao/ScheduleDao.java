package com.cyj.dao;

import com.cyj.model.ScheduleModel;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface ScheduleDao {
    ScheduleModel getUnpublishedModelByGoodsId(int id);
    int updateBuyNumber(@Param("buyNumber") int buyNumber, @Param("timestamp")Timestamp timestamp, @Param("id")int id);
    ScheduleModel findModelById(int id);
    int insertScheduleModel(ScheduleModel scheduleModel);
    List<ScheduleModel> getUnpublishScheduleTotalCount(@Param("isPublish")int isPublish, @Param("state")int state);
    List<ScheduleModel> getOnePageUnpublish(@Param("isPublish") int isPublish, @Param("state") int state, @Param("offset") int offset, @Param("pageSize") int pageSize);
    int publishChangeScheduleState(@Param("scheduleId")int scheduleId);
    int addPublishDate(@Param("publishDate")Timestamp publishDate, @Param("id")int id);
    int cancelPublish(int scheduleId);
    List<ScheduleModel> viewScheduleByGnameYear(@Param("goodsId") int goodsId, @Param("year1")int year1);
}
