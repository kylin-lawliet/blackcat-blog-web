package com.blackcat.java.designpattern.command;

/**
 * 电器接口
 * @author: blackcat
 * @date: 2019/12/29 9:06
 */
public interface  Switchable {
    // 通电
    void on();
    // 断电
    void off();
}
