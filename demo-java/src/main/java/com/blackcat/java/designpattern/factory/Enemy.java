package com.blackcat.java.designpattern.factory;

/**
 * 敌人
 * @author: blackcat
 * @date: 2019/12/22 8:40
 * 设计模式-工厂 示例
 */
public abstract  class Enemy {

    // 敌人的坐标，会被子类继承。
    protected int x,y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 抽象方法，在地图上绘制
     * @author: blackcat
     * @date: 2019/12/22 8:41
     * @Param []
    */
    public abstract void show();
}
