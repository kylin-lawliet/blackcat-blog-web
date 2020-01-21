package com.blackcat.java.designpattern.flyweight;

/**
 * @author: blackcat
 * @date: 2019/12/21 10:27
 * 设计模式-享元 示例
 */
public class Client {
    public static void main(String[] args) {
        //以绘制第一行为例
        /*new Tile("河流", 10, 10).draw();
        new Tile("河流", 10, 20).draw();
        new Tile("石路", 10, 30).draw();
        new Tile("草坪", 10, 40).draw();
        new Tile("草坪", 10, 50).draw();
        new Tile("草坪", 10, 60).draw();
        new Tile("草坪", 10, 70).draw();
        new Tile("草坪", 10, 80).draw();*/

        /* 运行结果
        从磁盘加载[河流]图片，耗时半秒。。。在位置[10:10]上绘制图片：[河流]
        从磁盘加载[河流]图片，耗时半秒。。。在位置[10:20]上绘制图片：[河流]
        从磁盘加载[石路]图片，耗时半秒。。。在位置[10:30]上绘制图片：[石路]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:40]上绘制图片：[草坪]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:50]上绘制图片：[草坪]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:60]上绘制图片：[草坪]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:70]上绘制图片：[草坪]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:80]上绘制图片：[草坪]
        */

        // 优化代码
        //先实例化图件工厂
        Factory factory = new Factory();
        //以第一行为例
        factory.getDrawable("河流").draw(10, 10);
        factory.getDrawable("河流").draw(10, 20);
        factory.getDrawable("石路").draw(10, 30);
        factory.getDrawable("草坪").draw(10, 40);
        factory.getDrawable("草坪").draw(10, 50);
        factory.getDrawable("草坪").draw(10, 60);
        factory.getDrawable("草坪").draw(10, 70);
        factory.getDrawable("草坪").draw(10, 80);
        factory.getDrawable("房子").draw(10, 90);
        /* 运行结果
        从磁盘加载[河流]图片，耗时半秒。。。在位置[10:10]上绘制图片：[河流]
        在位置[10:20]上绘制图片：[河流]
        从磁盘加载[石路]图片，耗时半秒。。。在位置[10:30]上绘制图片：[石路]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:40]上绘制图片：[草坪]
        在位置[10:50]上绘制图片：[草坪]
        在位置[10:60]上绘制图片：[草坪]
        在位置[10:70]上绘制图片：[草坪]
        在位置[10:80]上绘制图片：[草坪]
        从磁盘加载[房子]图片，耗时一秒。。。将图层切到最上层。。。
        在位置[10:90]上绘制图片：[房子]
        */
    }

}
