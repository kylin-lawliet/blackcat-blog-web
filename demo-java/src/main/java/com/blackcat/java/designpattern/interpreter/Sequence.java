package com.blackcat.java.designpattern.interpreter;

import java.util.List;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:48
 * 设计模式-解释器 示例
 */
public class Sequence implements Expression{

    private List<Expression> expressions;// 指令集序列

    public Sequence(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public void interpret() {
        // 循环挨个解析每条指令
        expressions.forEach(exp -> exp.interpret());
    }
}
