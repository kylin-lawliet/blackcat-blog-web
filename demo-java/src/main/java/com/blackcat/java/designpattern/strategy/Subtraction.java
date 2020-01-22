package com.blackcat.java.designpattern.strategy;

/**
 * 减法策略
 * FileName: Subtraction
 * @author :   blackcat
 * @serialData :     2019/11/22 10:50
 * 实现算法接口
 */
public class Subtraction implements Strategy{

    @Override
    public int calculate(int a, int b) {//减数与被减数
        return a - b;
    }
}
