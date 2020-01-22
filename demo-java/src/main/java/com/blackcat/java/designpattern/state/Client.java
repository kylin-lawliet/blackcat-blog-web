package com.blackcat.java.designpattern.state;

/**
 * FileName: Client
 * @author :   blackcat
 * @serialData :     2019/11/22 16:17
 * 设计模式-状态 示例
 */
public class Client {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        switcher.switchOff();// WARN!!!断电状态无需再关
        switcher.switchOn();// OK...灯亮
        switcher.switchOff();// OK...灯灭
        switcher.switchOn();// OK...灯亮
        switcher.switchOn();// WARN!!!通电状态无需再开
    }

}
