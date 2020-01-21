package com.blackcat.java.designpattern.visitor;

import java.time.LocalDate;

/**
 * 酒类
 * @author: blackcat
 * @date: 2019/12/30 8:27
 * 设计模式-访问者 示例
 */
public class Wine extends Product implements Acceptable{

    public Wine(String name, LocalDate producedDate, float price) {
        super(name, producedDate, price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);// 把自己交给拜访者。
    }
}
