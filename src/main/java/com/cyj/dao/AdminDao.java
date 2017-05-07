package com.cyj.dao;

import com.cyj.model.AdminModel;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface AdminDao {
    AdminModel findModelById(int id);
    AdminModel findModelByNT(String NT);
    int updatePassword(@Param("password")String password, @Param("NT")String NT);
}
