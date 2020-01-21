package com.blackcat.java.designpattern.factory;

/**
 * 飞机
 * @author: blackcat
 * @date: 2019/12/22 8:42
 * 设计模式-工厂 示例
 */
public class Airplane extends Enemy {

    public Airplane(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("飞机出现坐标：" + x + "," + y);
        System.out.println("飞机向玩家发起攻击……");
    }
}
