package com.cyj.dao.mybatis;

import com.cyj.dao.PayDao;
import com.cyj.model.PayModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class PayDaoImpl implements PayDao{
    @Resource
    private SqlSession sqlSession;

    public List<PayModel> viewPayInfoByOrderId(int orderId) {
        return sqlSession.getMapper(PayDao.class).viewPayInfoByOrderId(orderId);
    }

    public int insertItem(PayModel payModel) {
        return sqlSession.getMapper(PayDao.class).insertItem(payModel);
    }
}
