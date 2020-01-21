package com.blackcat.java.designpattern.bridging;

/**
 * 画笔
 * @author: blackcat
 * @date: 2019/12/24 7:47
 * 设计模式-桥梁 示例
 */
public abstract  class Pen {
    protected Ruler ruler;//尺子的引用

    public Pen(Ruler ruler) {
        this.ruler = ruler;
    }

    public abstract void draw();//抽象方法
}
