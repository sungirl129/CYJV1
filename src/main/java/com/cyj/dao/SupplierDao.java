package com.cyj.dao;

import com.cyj.model.SupplierModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
public interface SupplierDao {
    SupplierModel findModelById(int id);
    SupplierModel findModelByUsername(String username);
    int insertSupplier(SupplierModel supplierModel);
    List<SupplierModel> getAllSupplier();
    List<SupplierModel> getOnePageSupplier(@Param("offset")int offset,@Param("pageSize")int pageSize);
    int updateSupplier(SupplierModel supplierModel);
    int deleteSupplier(int id);
    int updatePassword(@Param("password") String password, @Param("id") int id);
}
