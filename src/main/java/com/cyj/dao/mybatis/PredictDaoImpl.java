package com.cyj.dao.mybatis;

import com.cyj.dao.PredictDao;
import com.cyj.model.PredictModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 */
@Repository
public class PredictDaoImpl implements PredictDao{
    @Resource
    private SqlSession sqlSession;

    @Override
    public List<PredictModel> getPredict(int goodsId) {
        return sqlSession.getMapper(PredictDao.class).getPredict(goodsId);
    }
}
