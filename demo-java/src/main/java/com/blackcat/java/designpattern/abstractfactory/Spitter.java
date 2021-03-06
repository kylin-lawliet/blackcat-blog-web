package com.blackcat.java.designpattern.abstractfactory;

/**
 * 外星毒液口水兵
 * @author: blackcat
 * @date: 2019/12/25 7:35
 * 设计模式-抽象工厂 示例
 */
public class Spitter extends Unit{
    public Spitter(int x, int y) {
        super(10, 8, 80, x, y);
    }

    @Override
    public void show() {
        System.out.println("口水兵出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("口水兵用毒液喷射，攻击力：" + attack);
    }
}
