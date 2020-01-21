package com.blackcat.java.designpattern.interpreter;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:51
 * 设计模式-解释器 示例
 */
public class RightDown implements Expression{

    @Override
    public void interpret() {
        System.out.println("按下鼠标：右键");
    }
}
