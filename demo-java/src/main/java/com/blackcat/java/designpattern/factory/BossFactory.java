package com.blackcat.java.designpattern.factory;

/**
 * Boss的工厂
 * @author: blackcat
 * @date: 2019/12/22 9:02
 * 设计模式-工厂 示例
 */
public class BossFactory implements Factory{
    @Override
    public Enemy create(int screenWidth) {
        // boss应该出现在屏幕中央
        return new Boss(screenWidth / 2, 0);
    }
}
