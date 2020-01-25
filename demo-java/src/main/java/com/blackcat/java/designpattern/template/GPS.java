package com.blackcat.java.designpattern.template;

/**
 * 导航的实现
 * FileName: GPS
 * @author :   blackcat
 * @date :     2019/11/25 15:57
 * 设计模式-模板方法 示例一
 */
public class GPS implements CigarLighterInterface {

    @Override
    public void electrifyDC16V() {
        System.out.println("连接卫星");
        System.out.println("定位。。。");
    }
}
