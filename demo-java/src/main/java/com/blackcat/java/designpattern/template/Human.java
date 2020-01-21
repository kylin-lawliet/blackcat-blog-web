package com.blackcat.java.designpattern.template;

/**
 * 人
 * FileName: Human
 * @author :   blackcat
 * @date :     2019/11/25 17:45
 * 设计模式-模板方法 示例二
 */
public class Human extends Mammal {

    @Override
    public void move() {
        System.out.println("两条腿走路……");
    }
}
