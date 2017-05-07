package com.cyj.dao.mybatis;

import com.cyj.dao.SupplierDao;
import com.cyj.model.SupplierModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
@Repository
public class SupplierDaoImpl implements SupplierDao {

    @Resource
    private SqlSession sqlSession;

    public SupplierModel findModelById(int id) {
        return sqlSession.getMapper(SupplierDao.class).findModelById(id);
    }

    public SupplierModel findModelByUsername(String username) {
        return sqlSession.getMapper(SupplierDao.class).findModelByUsername(username);
    }

    public int insertSupplier(SupplierModel supplierModel) {
        return sqlSession.getMapper(SupplierDao.class).insertSupplier(supplierModel);
    }

    public List<SupplierModel> getAllSupplier() {
        return sqlSession.getMapper(SupplierDao.class).getAllSupplier();
    }

    public List<SupplierModel> getOnePageSupplier(@Param("offset") int offset, @Param("pageSize") int pageSize) {
        return sqlSession.getMapper(SupplierDao.class).getOnePageSupplier(offset, pageSize);
    }

    public int updateSupplier(SupplierModel supplierModel) {
        return sqlSession.getMapper(SupplierDao.class).updateSupplier(supplierModel);
    }

    public int deleteSupplier(int id) {
        return sqlSession.getMapper(SupplierDao.class).deleteSupplier(id);
    }

    public int updatePassword(@Param("password") String password, @Param("id") int id) {
        return sqlSession.getMapper(SupplierDao.class).updatePassword(password, id);
    }
}
