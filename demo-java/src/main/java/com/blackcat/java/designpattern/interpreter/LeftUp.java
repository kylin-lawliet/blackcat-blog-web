package com.blackcat.java.designpattern.interpreter;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:42
 * 设计模式-解释器 示例
 */
public class LeftUp implements Expression{
    @Override
    public void interpret() {
        System.out.println("松开鼠标：左键");
    }
}
