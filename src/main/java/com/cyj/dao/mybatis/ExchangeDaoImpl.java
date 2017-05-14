package com.cyj.dao.mybatis;

import com.cyj.dao.ExchangeDao;
import com.cyj.model.ExchangeModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/12.
 */
@Repository
public class ExchangeDaoImpl implements ExchangeDao{
    @Resource
    private SqlSession sqlSession;

    @Override
    public int insertItem(ExchangeModel exchangeModel) {
        return sqlSession.getMapper(ExchangeDao.class).insertItem(exchangeModel);
    }
}
