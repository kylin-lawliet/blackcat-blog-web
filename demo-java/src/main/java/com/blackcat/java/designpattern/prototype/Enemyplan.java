package com.blackcat.java.designpattern.prototype;

/**
 * 飞机对象
 * FileName: Enemyplan
 * @author :   blackcat
 * @serialData :     2019/11/13 15:27
 * 设计模式-原型 示例
 * 示例场景:打飞机游戏(单机) 单架主机 N架敌机
 */
public class Enemyplan implements Cloneable{// Cloneable 此处实现克隆接口
    private Bullet bullet = new Bullet();
    private int x; // 敌机横坐标
    private int y; // 敌机纵坐标

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Enemyplan(int x) {// 构造器
        this.x = x;
    }

    public int getX() {
        return x;
    }

    // 此处开放setX 为了让克隆后的实例重新修改x坐标
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    /** *
     * 为了保证飞机飞行的连贯性
     * 这里我们关闭setY方法，不支持随意更改Y纵坐标
     * @author:     blackcat
     * @serialData : 2019/11/13 15:43
     * @param [y]
    */
    /*public void setY(int y) {
        this.y = y;
    }*/

    public void  fly(){// 让敌机飞
        y++;// 每调用一次,敌机飞行时纵坐标+1
    }

    /**
     * 重写克隆方法
     * @author:     blackcat
     * @serialData : 2019/11/13 15:56
     * @param []
     * Java中的变量分为原始类型和引用类型，所谓浅拷贝只是拷贝原始类型的指，
     * 比如坐标x, y的指会被拷贝到克隆对象中，对于对象bullet也会被拷贝，
     * 但是请注意拷贝的只是地址而已，那么多个地址其实真正指向的对象还是同一个bullet。
     * 由于调用父类Object的clone方法进行的是浅拷贝，所以此处的bullet并没有被克隆成功，
     * 比如每架敌机必须携带的子弹是不同的实例，那么我们就必须进行深拷贝
    */
    @Override
    protected  Enemyplan clone() throws CloneNotSupportedException{
        Enemyplan clonePlane = (Enemyplan) super.clone();//先克隆出敌机，其中子弹还未进行克隆。
        clonePlane.setBullet(this.bullet.clone());//对子弹进行深拷贝
        return clonePlane;
    }

}
