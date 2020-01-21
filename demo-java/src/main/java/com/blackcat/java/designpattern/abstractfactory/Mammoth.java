package com.blackcat.java.designpattern.abstractfactory;

/**
 * 外星猛犸巨兽
 * @author: blackcat
 * @date: 2019/12/25 7:36
 * 设计模式-抽象工厂 示例
 */
public class Mammoth extends Unit{
    public Mammoth(int x, int y) {
        super(20, 100, 400, x, y);
    }

    @Override
    public void show() {
        System.out.println("猛犸巨兽兵出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("猛犸巨兽用獠牙顶，攻击力：" + attack);
    }
}
