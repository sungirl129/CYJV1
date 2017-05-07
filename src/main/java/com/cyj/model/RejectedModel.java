package com.cyj.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/5.
 */
public class RejectedModel {
    private int id;
    private int arriveId;
    private int returnedQuantity;
    private Timestamp returnedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArriveId() {
        return arriveId;
    }

    public void setArriveId(int arriveId) {
        this.arriveId = arriveId;
    }

    public int getReturnedQuantity() {
        return returnedQuantity;
    }

    public void setReturnedQuantity(int returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

    public Timestamp getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Timestamp returnedDate) {
        this.returnedDate = returnedDate;
    }
}
