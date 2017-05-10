package com.cyj.dao;

import com.cyj.model.ApplicationModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface ApplicationDao {
    List<ApplicationModel> getApplicationTotalCountByValidAndState(@Param("valid")int valid, @Param("state")int state);
    List<ApplicationModel> getOnePageUncheckedApplication(@Param("valid")int valid, @Param("state")int state, @Param("offset")int offset, @Param("pageSize")int pageSize);
    int setValid(@Param("valid")int valid, @Param("id")int id);
    ApplicationModel findModelById(int id);
    int insertItem(ApplicationModel applicationModel);
    List<ApplicationModel> viewMyApplicationByState(@Param("supplierId")int supplierId, @Param("state")int state);
    List<ApplicationModel> viewMyApplicationByStateValid(@Param("supplierId")int supplierId, @Param("state")int state, @Param("valid")int valid);
    List<ApplicationModel> viewOnePageMyApplicationByState(@Param("supplierId")int supplierId, @Param("state")int state, @Param("offset")int offset, @Param("pageSize")int pageSize);
    List<ApplicationModel> getItemBySupplierIdAndValid(@Param("supplierId") int supplierId, @Param("valid") int valid);
    List<ApplicationModel> viewOnePageMyApplicationByValid(@Param("supplierId") int supplierId, @Param("valid") int valid, @Param("offset")int offset, @Param("pageSize")int pageSize);
}





