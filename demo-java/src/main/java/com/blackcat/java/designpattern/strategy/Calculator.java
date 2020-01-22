package com.blackcat.java.designpattern.strategy;

/**
 * 计算器
 * FileName: Calculator
 * @author :   blackcat
 * @serialData :     2019/11/22 10:43
 * 设计模式-策略 示例
 */
public class Calculator {

    //违反设计模式原则的做法
    /*public int add(int a,int b){//加法
        return a + b;
    }
    public int sub(int a,int b){//减法
        return a - b;
    }*/

    private Strategy strategy;//拥有某种算法策略

    public void setStrategy(Strategy strategy) {//接入算法策略
        this.strategy = strategy;
    }

    public int getResult(int a, int b){//返回具体策略的结果
        return this.strategy.calculate(a,b);
    }


}
