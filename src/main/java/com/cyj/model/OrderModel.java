package com.cyj.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/5.
 */
public class OrderModel {
    private int id;
    private int applicationId;
    private Timestamp validDate;
    private int acceptNumber;
    private double payedMoney;
    private int orderState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Timestamp getValidDate() {
        return validDate;
    }

    public void setValidDate(Timestamp validDate) {
        this.validDate = validDate;
    }

    public int getAcceptNumber() {
        return acceptNumber;
    }

    public void setAcceptNumber(int acceptNumber) {
        this.acceptNumber = acceptNumber;
    }

    public double getPayedMoney() {
        return payedMoney;
    }

    public void setPayedMoney(double payedMoney) {
        this.payedMoney = payedMoney;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
}
