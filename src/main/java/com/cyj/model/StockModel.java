package com.cyj.model;

/**
 * Created by Administrator on 2017/4/5.
 */
public class StockModel {
    private int id;
    private int goodsId;
    private String gname;
    private int nowNumber;
    private int minStore;
    private int maxStore;

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

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getNowNumber() {
        return nowNumber;
    }

    public void setNowNumber(int nowNumber) {
        this.nowNumber = nowNumber;
    }

    public int getMinStore() {
        return minStore;
    }

    public void setMinStore(int minStore) {
        this.minStore = minStore;
    }

    public int getMaxStore() {
        return maxStore;
    }

    public void setMaxStore(int maxStore) {
        this.maxStore = maxStore;
    }

    @Override
    public String toString() {
        return "StockModel{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", gname='" + gname + '\'' +
                ", nowNumber=" + nowNumber +
                ", minStore=" + minStore +
                ", maxStore=" + maxStore +
                '}';
    }
}
