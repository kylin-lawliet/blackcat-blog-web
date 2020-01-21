package com.blackcat.java.designpattern.factory;

/**
 * 坦克
 * @author: blackcat
 * @date: 2019/12/22 8:45
 * 设计模式-工厂 示例
 */
public class Tank extends Enemy{

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克出现坐标：" + x + "," + y);
        System.out.println("坦克向玩家发起攻击……");
    }
}
