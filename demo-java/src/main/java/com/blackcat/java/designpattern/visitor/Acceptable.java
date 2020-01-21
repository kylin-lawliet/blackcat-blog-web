package com.blackcat.java.designpattern.visitor;

/**
 * 接待者
 * @author: blackcat
 * @date: 2019/12/30 8:39
 * 设计模式-访问者 示例
 */
public interface Acceptable {
    // 主动接受拜访者
    void accept(Visitor visitor);
}
