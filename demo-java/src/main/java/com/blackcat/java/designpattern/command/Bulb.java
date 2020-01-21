package com.blackcat.java.designpattern.command;

/**
 * 灯泡
 * @author: blackcat
 * @date: 2019/12/29 9:07
 */
public class Bulb implements Switchable {
    @Override
    public void on() {
        System.out.println("通电，灯亮。");
    }

    @Override
    public void off() {
        System.out.println("断电，灯灭。");
    }
}
