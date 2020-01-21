package com.blackcat.java.designpattern.abstractfactory;

/**
 * 巨型战舰
 * @author: blackcat
 * @date: 2019/12/25 7:32
 * 设计模式-抽象工厂 示例
 */
public class Battleship extends Unit {
    public Battleship(int x, int y) {
        super(25, 200, 500, x, y);
    }

    @Override
    public void show() {
        System.out.println("战舰出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("战舰用激光炮打击，攻击力：" + attack);
    }
}
