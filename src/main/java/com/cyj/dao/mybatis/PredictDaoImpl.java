package com.cyj.dao.mybatis;

import com.cyj.dao.PredictDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/14.
 */
@Repository
public class PredictDaoImpl implements PredictDao{
    @Resource
    private SqlSession sqlSession;

}
