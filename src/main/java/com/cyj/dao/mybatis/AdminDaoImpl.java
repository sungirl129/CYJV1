package com.cyj.dao.mybatis;

import com.cyj.dao.AdminDao;
import com.cyj.model.AdminModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/31.
 */
@Repository
public class AdminDaoImpl implements AdminDao{
    @Resource
    private SqlSession sqlSession;

    public AdminModel findModelById(int id) {
        return sqlSession.getMapper(AdminDao.class).findModelById(id);
    }

    public AdminModel findModelByNT(String NT) {
        return sqlSession.getMapper(AdminDao.class).findModelByNT(NT);
    }

    public int updatePassword(@Param("password") String password, @Param("NT") String NT) {
        return sqlSession.getMapper(AdminDao.class).updatePassword(password, NT);
    }
}
