package com.blackcat.java.designpattern.strategy;

/**
 * 加法策略
 * FileName: Addition
 * @author :   blackcat
 * @serialData :     2019/11/22 10:49
 * 实现算法接口
 */
public class Addition implements Strategy{

    @Override
    public int calculate(int a, int b) {//加数与被加数
        return a + b;
    }
}
