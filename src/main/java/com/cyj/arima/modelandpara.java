package com.cyj.arima;

import java.util.Vector;

/**
 * Created by Administrator on 2017/5/6.
 */
public class modelandpara {
    int[] model;
    Vector<double[]> para;

    public modelandpara(int[] model, Vector<double[]> para) {
        this.model = model;
        this.para = para;
    }
}