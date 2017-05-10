package com.cyj.dao.mybatis;

import com.cyj.dao.ApplicationDao;
import com.cyj.model.ApplicationModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class ApplicationDaoImpl implements ApplicationDao{
    @Resource
    private SqlSession sqlSession;
    public List<ApplicationModel> getApplicationTotalCountByValidAndState(@Param("valid") int valid, @Param("state") int state) {
        return sqlSession.getMapper(ApplicationDao.class).getApplicationTotalCountByValidAndState(valid, state);
    }

    public List<ApplicationModel> getOnePageUncheckedApplication(@Param("valid")int valid, @Param("state")int state, @Param("offset") int offset, @Param("pageSize") int pageSize) {
        return sqlSession.getMapper(ApplicationDao.class).getOnePageUncheckedApplication(valid, state, offset, pageSize);
    }

    public int setValid(@Param("valid")int valid, @Param("id")int id) {
        return sqlSession.getMapper(ApplicationDao.class).setValid(valid, id);
    }

    public ApplicationModel findModelById(int id) {
        return sqlSession.getMapper(ApplicationDao.class).findModelById(id);
    }

    public int insertItem(ApplicationModel applicationModel) {
        return sqlSession.getMapper(ApplicationDao.class).insertItem(applicationModel);
    }

    public List<ApplicationModel> viewMyApplicationByState(@Param("supplierId") int supplierId, @Param("state") int state) {
        return sqlSession.getMapper(ApplicationDao.class).viewMyApplicationByState(supplierId, state);
    }

    @Override
    public List<ApplicationModel> viewMyApplicationByStateValid(@Param("supplierId") int supplierId, @Param("state") int state, @Param("valid") int valid) {
        return sqlSession.getMapper(ApplicationDao.class).viewMyApplicationByStateValid(supplierId, state, valid);
    }

    public List<ApplicationModel> viewOnePageMyApplicationByState(@Param("supplierId") int supplierId, @Param("state") int state, @Param("offset") int offset, @Param("pageSize") int pageSize) {
        return sqlSession.getMapper(ApplicationDao.class).viewOnePageMyApplicationByState(supplierId, state, offset, pageSize);
    }


    public List<ApplicationModel> getItemBySupplierIdAndValid(@Param("supplierId") int supplierId, @Param("valid") int valid) {
        return sqlSession.getMapper(ApplicationDao.class).getItemBySupplierIdAndValid(supplierId, valid);
    }

    @Override
    public List<ApplicationModel> viewOnePageMyApplicationByValid(@Param("supplierId") int supplierId, @Param("valid") int valid, @Param("offset") int offset, @Param("pageSize") int pageSize) {
        return sqlSession.getMapper(ApplicationDao.class).viewOnePageMyApplicationByValid(supplierId, valid, offset, pageSize);
    }
}
