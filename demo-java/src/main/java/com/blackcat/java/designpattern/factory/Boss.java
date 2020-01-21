package com.blackcat.java.designpattern.factory;

/**
 * @author: blackcat
 * @date: 2019/12/22 9:01
 * 设计模式-工厂 示例
 */
public class Boss extends Enemy{
    public Boss(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("Boss出现坐标：" + x + "," + y);
        System.out.println("Boss向玩家发起攻击……");
    }
}
