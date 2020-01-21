package com.blackcat.java.designpattern.command;

/**
 * 风扇
 * @author: blackcat
 * @date: 2019/12/29 9:08
 */
public class Fan implements Switchable{
    @Override
    public void on() {
        System.out.println("通电，风扇转动。");
    }

    @Override
    public void off() {
        System.out.println("断电，风扇停止。");
    }
}
