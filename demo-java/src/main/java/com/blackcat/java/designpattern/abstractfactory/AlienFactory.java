package com.blackcat.java.designpattern.abstractfactory;

/**
 * 外星虫族工厂
 * @author: blackcat
 * @date: 2019/12/25 7:41
 * 设计模式-抽象工厂 示例
 */
public class AlienFactory implements AbstractFactory{
    private int x,y;

    public AlienFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Unit createLowClass() {
        Unit unit = new Roach(x, y);
        System.out.println("制造蟑螂兵成功。");
        return unit;
    }

    @Override
    public Unit createMidClass() {
        Unit unit = new Spitter(x, y);
        System.out.println("制造毒液兵成功。");
        return unit;
    }

    @Override
    public Unit createHighClass() {
        Unit unit = new Mammoth(x, y);
        System.out.println("制造猛犸巨兽成功。");
        return unit;
    }
}
