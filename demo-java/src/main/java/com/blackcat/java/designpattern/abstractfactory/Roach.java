package com.blackcat.java.designpattern.abstractfactory;

/**
 * 外星蟑螂兵
 * @author: blackcat
 * @date: 2019/12/25 7:34
 * 设计模式-抽象工厂 示例
 */
public class Roach extends Unit{
    public Roach(int x, int y) {
        super(5, 2, 35, x, y);
    }

    @Override
    public void show() {
        System.out.println("蟑螂兵出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("蟑螂兵用爪子挠，攻击力：" + attack);
    }
}
