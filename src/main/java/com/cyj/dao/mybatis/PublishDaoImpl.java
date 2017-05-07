package com.cyj.dao.mybatis;

import com.cyj.dao.PublishDao;
import com.cyj.model.PublishModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
@Repository
public class PublishDaoImpl implements PublishDao{
    @Resource
    private SqlSession sqlSession;

    public PublishModel findModelById(int id) {
        return sqlSession.getMapper(PublishDao.class).findModelById(id);
    }

    public PublishModel getPublishModelByGoodsId(int id) {
        return sqlSession.getMapper(PublishDao.class).getPublishModelByGoodsId(id);
    }

    public int changePublishNumber(PublishModel model) {
        return sqlSession.getMapper(PublishDao.class).changePublishNumber(model);
    }

    public int insertPublishItem(PublishModel model) {
        return sqlSession.getMapper(PublishDao.class).insertPublishItem(model);
    }

    public List<PublishModel> getPublishTotalCountByState(int state) {
        return sqlSession.getMapper(PublishDao.class).getPublishTotalCountByState(state);
    }

    public List<PublishModel> getOnePagePublishByState(@Param("state") int state, @Param("offset") int offset, @Param("pageSize") int pageSize) {
        return sqlSession.getMapper(PublishDao.class).getOnePagePublishByState(state, offset, pageSize);
    }

    public int cacelPublish(int pid) {
        return sqlSession.getMapper(PublishDao.class).cacelPublish(pid);
    }


    public int changeApplyNumber(@Param("applyNumber") int applyNumber, @Param("id") int id) {
        return sqlSession.getMapper(PublishDao.class).changeApplyNumber(applyNumber, id);
    }

    public int changeState(@Param("state") int state, @Param("id") int id) {
        return sqlSession.getMapper(PublishDao.class).changeState(state, id);
    }

    public int deleteItem(int id) {
        return sqlSession.getMapper(PublishDao.class).deleteItem(id);
    }
}
