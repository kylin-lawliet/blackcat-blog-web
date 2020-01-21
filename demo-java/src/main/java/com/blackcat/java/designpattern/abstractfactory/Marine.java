package com.blackcat.java.designpattern.abstractfactory;

/**
 * 海军陆战队士兵
 * @author: blackcat
 * @date: 2019/12/25 6:58
 * 设计模式-抽象工厂 示例
 */
public class Marine extends Unit{
    public Marine(int x, int y) {
        super(6, 5, 40, x, y);
    }

    @Override
    public void show() {
        System.out.println("士兵出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("士兵用机关枪射击，攻击力：" + attack);
    }
}
