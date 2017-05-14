package com.cyj.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/6.
 */
@Service
public class PredictService {
    public int[] predict() {
        int[] plan = new int[12];
        for(int i = 0; i < 12; i++) {
            plan[i] = (int)(1 + Math.random() * (10-1+1));
        }
        return plan;
    }
}
