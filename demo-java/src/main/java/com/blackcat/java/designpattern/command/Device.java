package com.blackcat.java.designpattern.command;

/**
 * 设备
 * @author: blackcat
 * @date: 2019/12/29 9:13
 */
interface  Device extends  Switchable {
    // 频道+
    void channelUp();
    // 频道-
    void channelDown();
    // 音量+
    void volumeUp();
    // 音量-
    void volumeDown();
}
