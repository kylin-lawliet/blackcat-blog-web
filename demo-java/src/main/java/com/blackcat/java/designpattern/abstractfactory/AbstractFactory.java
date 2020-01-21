package com.blackcat.java.designpattern.abstractfactory;

/**
 * @author: blackcat
 * @date: 2019/12/25 7:37
 * 设计模式-抽象工厂 示例
 */
public interface  AbstractFactory {

    Unit createLowClass();// 工厂方法：制造低级兵种

    Unit createMidClass();// 工厂方法：制造中级兵种

    Unit createHighClass();// 工厂方法：制造高级兵种
}
