package com.blackcat.java.designpattern.visitor;

import java.time.LocalDate;

/**
 * @author: blackcat
 * @date: 2019/12/30 8:29
 * 设计模式-访问者 示例
 */
public class Fruit extends Product implements Acceptable{
    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Fruit(String name, LocalDate producedDate, float price,float weight) {
        super(name, producedDate, price);
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);// 把自己交给拜访者。
    }
}
