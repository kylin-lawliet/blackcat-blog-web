package com.blackcat.java.designpattern.flyweight;

/**
 * 河流
 * @author: blackcat
 * @date: 2019/12/21 10:31
 * 设计模式-享元 示例
 */
public class Water implements Drawable {
    private String image;//河流图片材质

    public Water() {
        this.image = "河流";
        System.out.print("从磁盘加载[" + image + "]图片，耗时半秒。。。");
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
}
