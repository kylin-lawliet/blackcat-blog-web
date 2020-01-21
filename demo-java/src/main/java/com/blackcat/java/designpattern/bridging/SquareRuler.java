package com.blackcat.java.designpattern.bridging;

/**
 * 正方尺
 * @author: blackcat
 * @date: 2019/12/24 7:44
 * 设计模式-桥梁 示例
 */
public class SquareRuler implements Ruler{

    @Override
    public void regularize() {
        // 尺子模板画出正方形
        System.out.println("□");
    }
}
