package com.cyj.model;

import com.cyj.excel.SheetHandler;
import com.cyj.excel.SheetRowConversion;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/5.
 */
public class ScheduleModel implements SheetRowConversion {

    public static final String[] HEADER = new String[]{"名称","数量"};

    private int id;
    private int goodsId;
    private int buyNumber;
    private int isPublish;
    private int scheduleState;
    private Timestamp scheduleDate;
    private Timestamp publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public int getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(int isPublish) {
        this.isPublish = isPublish;
    }

    public int getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(int scheduleState) {
        this.scheduleState = scheduleState;
    }

    public Timestamp getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Timestamp scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 导入：商品名称
     * */
    private String gname;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * 导入
     * */
    @Override
    public SheetRowConversion convertToModel(Row row) {
        this.gname = SheetHandler.getStringValueFromCell(row.getCell(0));
        this.buyNumber = (int) SheetHandler.getNumericValueFromCell(row.getCell(1));
        return this;
    }

    @Override
    public Row convertToRow(Row row) {
        return null;
    }
}
