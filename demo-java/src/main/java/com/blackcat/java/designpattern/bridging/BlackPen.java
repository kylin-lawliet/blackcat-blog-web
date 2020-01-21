package com.blackcat.java.designpattern.bridging;

/**
 * 黑笔
 * @author: blackcat
 * @date: 2019/12/24 7:48
 * 设计模式-桥梁 示例
 */
public class BlackPen extends Pen{

    public BlackPen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.print("黑");
        ruler.regularize();
    }
}
