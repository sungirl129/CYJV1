package com.cyj.model.show;

import com.cyj.dao.StockDao;
import com.cyj.excel.SheetHandler;
import com.cyj.excel.SheetRowConversion;
import com.cyj.model.GoodsModel;
import com.cyj.model.StockModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by zhuangqf on 5/7/17.
 */
public class Stock implements SheetRowConversion {

    public static final String[] HEADER = new String[]{"名称","单位",
    "规格","备注","现有库存","最大库存","最小库存"};

    private StockModel stockModel;
    private GoodsModel goodsModel;

    public StockModel getStockModel() {
        return stockModel;
    }

    public void setStockModel(StockModel stockModel) {
        this.stockModel = stockModel;
    }

    public GoodsModel getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(GoodsModel goodsModel) {
        this.goodsModel = goodsModel;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockModel=" + stockModel +
                ", goodsModel=" + goodsModel +
                '}';
    }

    @Override
    public SheetRowConversion convertToModel(Row row) {
        return null;
    }

    @Override
    public Row convertToRow(Row row) {
        Cell gnameCell = row.createCell(0);
        gnameCell.setCellValue(this.goodsModel.getGname());
        Cell unitCell = row.createCell(1);
        unitCell.setCellValue(this.goodsModel.getUnit());
        Cell specCell = row.createCell(2);
        specCell.setCellValue(this.goodsModel.getSpec());
        Cell noteCell = row.createCell(3);
        noteCell.setCellValue(this.goodsModel.getNote());
        this.stockModel.getNowNumber();
        Cell nowCell = row.createCell(4);
        nowCell.setCellValue(this.stockModel.getNowNumber());
        Cell minCell = row.createCell(5);
        minCell.setCellValue(this.stockModel.getMinStore());
        Cell maxCell = row.createCell(6);
        maxCell.setCellValue(this.stockModel.getMaxStore());
        return row;
    }
}
