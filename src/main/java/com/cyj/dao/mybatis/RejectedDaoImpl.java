package com.cyj.dao.mybatis;

import com.cyj.dao.RejectedDao;
import com.cyj.model.RejectedModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class RejectedDaoImpl implements RejectedDao {
    @Resource
    private SqlSession sqlSession;
    public int insertItem(RejectedModel rejectedModel) {
        return sqlSession.getMapper(RejectedDao.class).insertItem(rejectedModel);
    }
}
