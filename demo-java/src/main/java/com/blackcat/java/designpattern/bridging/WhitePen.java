package com.blackcat.java.designpattern.bridging;

/**
 * 白笔
 * @author: blackcat
 * @date: 2019/12/24 7:49
 * 设计模式-桥梁 示例
 */
public class WhitePen extends Pen{

    public WhitePen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.print("白");
        ruler.regularize();
    }
}
