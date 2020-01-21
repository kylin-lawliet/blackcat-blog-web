package com.blackcat.java.designpattern.interpreter;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:41
 * 设计模式-解释器 示例
 */
public class Move implements Expression{
    // 鼠标位置坐标
    private int x, y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void interpret() {
        System.out.println("移动鼠标：【" + x + "," + y + "】");
    }
}
