package com.cyj.dao.mybatis;

import com.cyj.dao.ScheduleDao;
import com.cyj.model.ScheduleModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class ScheduleDaoImpl implements ScheduleDao{
    @Resource
    private SqlSession sqlSession;
    public ScheduleModel getUnpublishedModelByGoodsId(int id) {
        return sqlSession.getMapper(ScheduleDao.class).getUnpublishedModelByGoodsId(id);
    }

    public int updateBuyNumber(@Param("buyNumber") int buyNumber, @Param("timestamp") Timestamp timestamp, @Param("id") int id) {
        return sqlSession.getMapper(ScheduleDao.class).updateBuyNumber(buyNumber,timestamp,id);
    }

    public ScheduleModel findModelById(int id) {
        return sqlSession.getMapper(ScheduleDao.class).findModelById(id);
    }

    public int insertScheduleModel(ScheduleModel scheduleModel) {
        return sqlSession.getMapper(ScheduleDao.class).insertScheduleModel(scheduleModel);
    }

    public List<ScheduleModel> getUnpublishScheduleTotalCount(@Param("isPublish")int isPublish, @Param("state")int state) {
        return sqlSession.getMapper(ScheduleDao.class).getUnpublishScheduleTotalCount(isPublish, state);
    }

    public List<ScheduleModel> getOnePageUnpublish(@Param("isPublish") int isPublish, @Param("state") int state, @Param("offset")int offset, @Param("pageSize")int pageSize) {
        return sqlSession.getMapper(ScheduleDao.class).getOnePageUnpublish(isPublish, state, offset, pageSize);
    }

    public int publishChangeScheduleState(@Param("scheduleId") int scheduleId) {
        return sqlSession.getMapper(ScheduleDao.class).publishChangeScheduleState(scheduleId);
    }

    public int addPublishDate(@Param("publishDate") Timestamp publishDate, @Param("id") int id) {
        return sqlSession.getMapper(ScheduleDao.class).addPublishDate(publishDate, id);
    }

    public int cancelPublish(int scheduleId) {
        return sqlSession.getMapper(ScheduleDao.class).cancelPublish(scheduleId);
    }

    public List<ScheduleModel> viewScheduleByGnameYear(@Param("goodsId") int goodsId, @Param("year1") int year1) {
        return sqlSession.getMapper(ScheduleDao.class).viewScheduleByGnameYear(goodsId, year1);
    }
}
