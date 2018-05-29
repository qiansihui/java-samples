package com.javacore.object.abstractdemo;

/**
 * @Author: sunqianqian
 * @Description: 汽车速度表
 * @CodeReviewer:
 */
public class CarSpeedMeter extends SpeedMeter {
    @Override
    public double getRadius() {
        return 0.21;
    }

    public static void main(String[] args) {
        CarSpeedMeter carSpeedMeter = new CarSpeedMeter();
        carSpeedMeter.setTurnRate(14);
        System.out.println(carSpeedMeter.getSpeed());
    }
}
