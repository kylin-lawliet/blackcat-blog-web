package com.blackcat.java.designpattern.prototype;

/**
 * 子弹
 * FileName: Bullet
 * @author :   blackcat
 * @serialData :     2019/11/13 15:50
 */
public class Bullet  implements Cloneable{

    @Override
    public Bullet clone()throws CloneNotSupportedException{
        return (Bullet) super.clone();
    }
}
