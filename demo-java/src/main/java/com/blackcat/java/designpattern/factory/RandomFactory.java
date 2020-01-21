package com.blackcat.java.designpattern.factory;

import java.util.Random;

/**
 * 随机工厂
 * @author: blackcat
 * @date: 2019/12/22 8:59
 * 设计模式-工厂 示例
 */
public class RandomFactory implements Factory{
    private Random random = new Random();

    @Override
    public Enemy create(int screenWidth) {
        Enemy enemy = null;
        if (random.nextBoolean()) {
            enemy = new Airplane(random.nextInt(screenWidth), 0);//实例化飞机
        } else {
            enemy = new Tank(random.nextInt(screenWidth), 0);//实例化坦克
        }
        return enemy;
    }
}
