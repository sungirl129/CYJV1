package com.cyj.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/5.
 */
public class ApplicationModel {
    private int id;
    private int publishId;
    private int scheduleId;
    private int supplierId;
    private int supplyNumber;
    private double price;
    private int  valid;
    private int applicationState;
    private Timestamp applicationDate;

    private String strValid;

    public String getStrValid() {
        return strValid;
    }

    public void setStrValid(String strValid) {
        this.strValid = strValid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getSupplyNumber() {
        return supplyNumber;
    }

    public void setSupplyNumber(int supplyNumber) {
        this.supplyNumber = supplyNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(int applicationState) {
        this.applicationState = applicationState;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }
}
