package com.cyj.arima;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        try {
            ArrayList<Double> arraylist = new ArrayList<Double>();
            Scanner ino = new Scanner(new File("E:\\bishe\\download\\Arima\\Arima\\Data\\ceshidata.txt"));
            while (ino.hasNext()) {
                arraylist.add(Double.parseDouble(ino.next()));
            }
            ino.close();
            double[] dataArray = new double[arraylist.size()];
            for (int i = 0; i < arraylist.size(); i++)
                dataArray[i] = arraylist.get(i);
            System.out.println("个数：" + arraylist.size());
            ARIMA arima = new ARIMA(dataArray);
            int[] model = arima.getARIMAmodel();
            System.out.println("Best model is [p,q]=" + "[" + model[0] + " " + model[1] + "]");
            System.out.println(arima.aftDeal(arima.predictValue(model[0], model[1])));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
