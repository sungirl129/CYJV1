package com.cyj.arima;

import java.util.*;

public class AR {
    private double[] stdoriginalData = {};
    private int p;
    private ARMAMath armamath = new ARMAMath();

    //AR模型：p为MA模型阶数
    public AR(double [] stdoriginalData, int p) {
        this.stdoriginalData = new double[stdoriginalData.length];
        System.arraycopy(stdoriginalData, 0, this.stdoriginalData, 0, stdoriginalData.length);
        this.p = p;
    }

    //返回AR模型参数
    public Vector<double[]> ARmodel() {
        Vector<double[]> v = new Vector<double[]>();
        v.add(armamath.parcorrCompute(stdoriginalData, p, 0));
        return v;//得到了自回归系数
    }
}