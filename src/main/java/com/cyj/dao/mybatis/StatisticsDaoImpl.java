package com.cyj.dao.mybatis;

import com.cyj.dao.StatisticsDao;
import com.cyj.model.StatisticsModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class StatisticsDaoImpl implements StatisticsDao{
    @Resource
    private SqlSession sqlSession;

    public StatisticsModel findModelById(int id) {
        return sqlSession.getMapper(StatisticsDao.class).findModelById(id);
    }

    public int insertItem(StatisticsModel model) {
        return sqlSession.getMapper(StatisticsDao.class).insertItem(model);
    }

    public StatisticsModel findModelByGoodsIdAndTime(@Param("gid") int gid, @Param("year") int year, @Param("month") int month) {
        return sqlSession.getMapper(StatisticsDao.class).findModelByGoodsIdAndTime(gid, year, month);
    }

    public int updatePurchaseNumber(@Param("purchaseNumber") int purchaseNumber, @Param("id") int id) {
        return sqlSession.getMapper(StatisticsDao.class).updatePurchaseNumber(purchaseNumber, id);
    }

    public int updateApplyNumber(@Param("applyNumber") int applyNumber, @Param("id") int id) {
        return sqlSession.getMapper(StatisticsDao.class).updateApplyNumber(applyNumber, id);
    }

    public List<StatisticsModel> getModelsByGidAndYear(@Param("gid") int gid, @Param("year") int year) {
        return sqlSession.getMapper(StatisticsDao.class).getModelsByGidAndYear(gid, year);
    }
}
