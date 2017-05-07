package com.cyj.dao;

import com.cyj.model.PublishModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public interface PublishDao {
    PublishModel findModelById(int id);
    PublishModel getPublishModelByGoodsId(int id);
    int changePublishNumber(PublishModel model);
    int insertPublishItem(PublishModel model);
    List<PublishModel> getPublishTotalCountByState(int state);
    List<PublishModel> getOnePagePublishByState(@Param("state")int state, @Param("offset")int offset, @Param("pageSize")int pageSize);
    int cacelPublish(int pid);
    int changeApplyNumber(@Param("applyNumber") int applyNumber, @Param("id") int id);
    int changeState(@Param("state")int state, @Param("id")int id);
    int deleteItem(int id);
}
