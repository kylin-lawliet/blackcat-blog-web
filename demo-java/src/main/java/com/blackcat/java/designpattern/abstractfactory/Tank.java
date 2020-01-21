package com.blackcat.java.designpattern.abstractfactory;

/**
 * @author: blackcat
 * @date: 2019/12/25 6:59
 * 设计模式-抽象工厂 示例
 */
public class Tank extends Unit {
    public Tank(int x, int y) {
        super(25, 100, 150, x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("坦克用炮轰击，攻击力：" + attack);
    }
}
