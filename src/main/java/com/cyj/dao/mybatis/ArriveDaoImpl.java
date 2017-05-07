package com.cyj.dao.mybatis;

import com.cyj.dao.ArriveDao;
import com.cyj.model.ArriveModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class ArriveDaoImpl implements ArriveDao{
    @Resource
    private SqlSession sqlSession;

    public List<ArriveModel> getModelListByOrderId(int orderId) {
        return sqlSession.getMapper(ArriveDao.class).getModelListByOrderId(orderId);
    }

    public int insertArriveItem(ArriveModel arriveModel) {
        return sqlSession.getMapper(ArriveDao.class).insertArriveItem(arriveModel);
    }
}
