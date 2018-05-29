package com.javacore.object.abstractdemo;

/**
 * @Author: sunqianqian
 * @Description:车速表
 * @CodeReviewer:
 */
public abstract class SpeedMeter {
    //转速
    private double turnRate;

    public SpeedMeter() {
    }

    //把返回车轮半径的方法定义为抽象方法
    public abstract double getRadius();

    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }

    //定义计算速度的通用方法
    public double getSpeed() {
        return Math.PI * 2 * getRadius() * turnRate;
    }
}
