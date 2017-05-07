package com.cyj.dao.mybatis;

import com.cyj.dao.StockDao;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import com.cyj.model.show.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
@Repository
public class StockDaoImpl implements StockDao {
    @Resource
    private SqlSession sqlSession;

    public List<GoodsModel> getStockTotalItem() {
        return sqlSession.getMapper(StockDao.class).getStockTotalItem();
    }

    public List<GoodsModel> getOnePageGoodsInfo(int offset, int pageSize) {
        return sqlSession.getMapper(StockDao.class).getOnePageGoodsInfo(offset, pageSize);
    }

    public List<GoodsModel> searchGoodsByGnameCondition(String condition) {
        return sqlSession.getMapper(StockDao.class).searchGoodsByGnameCondition(condition);
    }

    public List<GoodsModel> searchGoodsByUnitCondition(String condition) {
        return sqlSession.getMapper(StockDao.class).searchGoodsByUnitCondition(condition);
    }

    public List<GoodsModel> searchOnePageGoodsByGnameCondition(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("condition") String condition) {
        return sqlSession.getMapper(StockDao.class).searchOnePageGoodsByGnameCondition(offset, pageSize, condition);
    }

    public List<GoodsModel> searchOnePageGoodsByUnitCondition(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("condition") String condition) {
        return sqlSession.getMapper(StockDao.class).searchOnePageGoodsByUnitCondition(offset, pageSize, condition);
    }

    public StockModel findStockModelByGoodsId(int id) {
        return sqlSession.getMapper(StockDao.class).findStockModelByGoodsId(id);
    }

    public GoodsModel findGoodsModelByGoodsId(int id) {
        return sqlSession.getMapper(StockDao.class).findGoodsModelByGoodsId(id);
    }

    public GoodsModel findGoodsModelByGname(String name) {
        return sqlSession.getMapper(StockDao.class).findGoodsModelByGname(name);
    }

    @Override
    public List<Stock> search(@Param("unit") String unit, @Param("gname") String gname, @Param("minStock") int minStock, @Param("maxStock") int maxStock) {
        return sqlSession.getMapper(StockDao.class).search(unit,gname,minStock,maxStock);
    }
}
