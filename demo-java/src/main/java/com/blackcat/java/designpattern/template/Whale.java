package com.blackcat.java.designpattern.template;

/**
 * 鲸鱼
 * FileName: Whale
 * @author :   blackcat
 * @date :     2019/11/25 17:47
 * 设计模式-模板方法 示例二
 */
public class Whale extends Mammal{

    @Override
    public void move() {
        System.out.println("游泳……");
    }
}
