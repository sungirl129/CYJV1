package com.cyj.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/5.
 */
public class ArriveModel {
    private int id;
    private int orderId;
    private int arriveNumber;
    private int goodsState;
    private int badNumber;
    private Timestamp arriveDate;
    private int processWay;
    private int exchangeNumber;
    private String strGoodsState;
    private int returnedNumber;
    private String strProcessWay;

    public int getReturnedNumber() {
        return returnedNumber;
    }

    public void setReturnedNumber(int returnedNumber) {
        this.returnedNumber = returnedNumber;
    }

    public String getStrProcessWay() {
        return strProcessWay;
    }

    public void setStrProcessWay(String strProcessWay) {
        this.strProcessWay = strProcessWay;
    }

    public String getStrGoodsState() {
        return strGoodsState;
    }

    public void setStrGoodsState(String strGoodsState) {
        this.strGoodsState = strGoodsState;
    }

    public int getProcessWay() {
        return processWay;
    }

    public void setProcessWay(int processWay) {
        this.processWay = processWay;
    }

    public int getExchangeNumber() {
        return exchangeNumber;
    }

    public void setExchangeNumber(int exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }

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

    public int getArriveNumber() {
        return arriveNumber;
    }

    public void setArriveNumber(int arriveNumber) {
        this.arriveNumber = arriveNumber;
    }

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public int getBadNumber() {
        return badNumber;
    }

    public void setBadNumber(int badNumber) {
        this.badNumber = badNumber;
    }

    public Timestamp getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Timestamp arriveDate) {
        this.arriveDate = arriveDate;
    }
}
