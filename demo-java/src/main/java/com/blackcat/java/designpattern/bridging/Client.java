package com.blackcat.java.designpattern.bridging;

/**
 * @author: blackcat
 * @date: 2019/12/24 7:50
 * 设计模式-桥梁 示例
 */
public class Client {
    public static void main(String[] args) {
        //白色画笔对应的所有形状
        new WhitePen(new CircleRuler()).draw();
        new WhitePen(new SquareRuler()).draw();
        new WhitePen(new TriangleRuler()).draw();

        //黑色画笔对应的所有形状
        new BlackPen(new CircleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();
    }
}
