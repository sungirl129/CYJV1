package com.cyj.model;

/**
 * Created by Administrator on 2017/5/12.
 */
public class ExchangeModel {
    private int id;
    private int orderId;
    private int arriveId;
    private int exchangeNumber;
    private int isArrive;
    private int goodsState;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getArriveId() {
        return arriveId;
    }

    public void setArriveId(int arriveId) {
        this.arriveId = arriveId;
    }

    public int getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(int exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }

    public int getIsArrive() {
        return isArrive;
    }

    public void setIsArrive(int isArrive) {
        this.isArrive = isArrive;
    }

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
