package com.blackcat.java.designpattern.strategy;

/**
 * 计算器客户端
 * FileName: Client
 * @author :   blackcat
 * @serialData :     2019/11/22 10:54
 * 设计模式-策略 示例
 */
public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();//实例化计算器
        calculator.setStrategy(new Addition());//接入加法实现
        int result = calculator.getResult(1, 1);//计算！
        System.out.println(result);//得到的是加法结果2

        calculator.setStrategy(new Subtraction());//再次接入减法实现
        int result2 = calculator.getResult(1, 1);//计算！
        System.out.println(result2);//得到的是减法结果0

    }



}
