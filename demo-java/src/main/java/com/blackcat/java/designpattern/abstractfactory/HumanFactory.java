package com.blackcat.java.designpattern.abstractfactory;

/**
 * 人族工厂
 * @author: blackcat
 * @date: 2019/12/25 7:38
 * 设计模式-抽象工厂 示例
 */
public class HumanFactory implements AbstractFactory{
    private int x,y;

    public HumanFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Unit createLowClass() {
        Unit unit = new Marine(x, y);
        System.out.println("制造海军陆战队员成功。");
        return unit;
    }

    @Override
    public Unit createMidClass() {
        Unit unit = new Tank(x, y);
        System.out.println("制造变形坦克成功。");
        return unit;
    }

    @Override
    public Unit createHighClass() {
        Unit unit = new Battleship(x, y);
        System.out.println("制造巨型战舰成功。");
        return unit;
    }
}
