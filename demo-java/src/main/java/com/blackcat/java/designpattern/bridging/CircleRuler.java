package com.blackcat.java.designpattern.bridging;

/**
 * 圆尺
 * @author: blackcat
 * @date: 2019/12/24 7:46
 * 设计模式-桥梁 示例
 */
public class CircleRuler implements Ruler {

    @Override
    public void regularize() {
        // 尺子模板画出圆形
        System.out.println("○");
    }
}
