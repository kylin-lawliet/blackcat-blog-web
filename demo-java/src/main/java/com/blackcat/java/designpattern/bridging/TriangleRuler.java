package com.blackcat.java.designpattern.bridging;

/**
 * 三角尺
 * @author: blackcat
 * @date: 2019/12/24 7:45
 * 设计模式-桥梁 示例
 */
public class TriangleRuler implements Ruler{

    @Override
    public void regularize() {
        // 尺子模板画出三角形
        System.out.println("△");
    }
}
