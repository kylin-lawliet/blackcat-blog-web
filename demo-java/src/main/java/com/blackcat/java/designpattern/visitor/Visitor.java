package com.blackcat.java.designpattern.visitor;

/**
 * 访问者接口
 * @author: blackcat
 * @date: 2019/12/30 8:30
 * 设计模式-访问者 示例
 */
interface Visitor {

    void visit(Candy candy);// 糖果重载方法

    void visit(Wine wine);// 酒类重载方法

    void visit(Fruit fruit);// 水果重载方法
}
