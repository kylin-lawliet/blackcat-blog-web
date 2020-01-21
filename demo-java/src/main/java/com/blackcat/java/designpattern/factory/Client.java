package com.blackcat.java.designpattern.factory;

/**
 * @author: blackcat
 * @date: 2019/12/22 8:46
 * 设计模式-工厂 示例
 */
public class Client {
    public static void main(String[] args) {
        /*int screenWidth = 100;// 屏幕宽度
        System.out.println("游戏开始");
        Random random = new Random();// 准备随机数
        int x = random.nextInt(screenWidth);// 生成敌机横坐标随机数
        Enemy airplan = new Airplane(x, 0);// 实例化飞机
        airplan.show();// 显示飞机

        x = random.nextInt(screenWidth);// 坦克同上
        Enemy tank = new Tank(x, 0);
        tank.show();*/

        // 优化代码
        /*System.out.println("游戏开始");
        SimpleFactory factory = new SimpleFactory(100);
        factory.create("Airplane").show();
        factory.create("Tank").show();*/

        int screenWidth = 100;
        System.out.println("游戏开始");
        Factory factory = new RandomFactory();
        for (int i = 0; i < 10; i++) {
            factory.create(screenWidth).show();
        }
        System.out.println("抵达关底");
        factory = new BossFactory();
        factory.create(screenWidth).show();
    }
}
