package com.blackcat.java.designpattern.prototype;

/**
 * 飞机制造工厂
 * FileName: EnemyPlaneFactory
 * @author :   blackcat
 * @date :     2019/11/13 15:45
 */
public class EnemyPlaneFactory {
    // 此处用痴汉模式造一个敌机原型
    private static Enemyplan prototype = new Enemyplan(200);

    // 获取敌机克隆实例
    public static Enemyplan getInstance(int x) throws CloneNotSupportedException {
        Enemyplan clone = prototype.clone();// 复制原型机
        clone.setX(x);// 重新设置克隆机的x坐标
        return clone;
    }
}
