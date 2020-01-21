package com.blackcat.java.designpattern.interpreter;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:46
 * 设计模式-解释器 示例
 */
public class Repetition implements Expression{
    private int loopCount;// 循环次数
    private Expression expression;// 循环体表达式

    public Repetition( Expression expression, int loopCount) {
        this.loopCount = loopCount;
        this.expression = expression;
    }

    @Override
    public void interpret() {
        while (loopCount > 0) {
            expression.interpret();
            loopCount--;
        }
    }
}
