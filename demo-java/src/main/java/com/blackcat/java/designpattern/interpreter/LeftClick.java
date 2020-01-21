package com.blackcat.java.designpattern.interpreter;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:45
 * 设计模式-解释器 示例
 */
public class LeftClick implements Expression{
    private Expression leftDown;
    private Expression leftUp;

    public LeftClick() {
        this.leftDown = new LeftDown();
        this.leftUp = new LeftUp();
    }

    @Override
    public void interpret() {
        // 单击=先按下再松开
        leftDown.interpret();
        leftUp.interpret();
    }
}
