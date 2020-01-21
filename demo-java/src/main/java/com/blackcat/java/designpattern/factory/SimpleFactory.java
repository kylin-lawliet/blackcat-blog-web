package com.blackcat.java.designpattern.factory;

import java.util.Random;

/**
 * 简单的工厂
 * @author: blackcat
 * @date: 2019/12/22 8:48
 * 设计模式-工厂 示例
 */
public class SimpleFactory {
    private int screenWidth;
    private Random random;// 随机数

    public SimpleFactory(int screenWidth) {
        this.screenWidth = screenWidth;
        this.random = new Random();
    }

    public Enemy create(String type){
        int x = random.nextInt(screenWidth);// 生成敌人横坐标随机数
        Enemy enemy = null;
        switch (type) {
            case "Airplane":
                enemy = new Airplane(x, 0);// 实例化飞机
                break;
            case "Tank":
                enemy = new Tank(x, 0);// 实例化坦克
                break;
        }
        return enemy;
    }
}
