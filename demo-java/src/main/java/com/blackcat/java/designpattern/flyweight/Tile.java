package com.blackcat.java.designpattern.flyweight;

/**
 * 瓦片/砖块
 * @author: blackcat
 * @date: 2019/12/21 10:25
 */
public class Tile {

    private String image;// 地砖所用的图片材质
    private int x, y;// 地砖所在坐标

    public Tile(String image, int x, int y) {
        this.image = image;
        System.out.print("从磁盘加载[" + image + "]图片，耗时半秒。。。");
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
}
