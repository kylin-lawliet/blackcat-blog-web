package com.blackcat.java.designpattern.command;

/**
 * 频道
 * @author: blackcat
 * @date: 2019/12/29 9:20
 */
public class ChannelCommand implements Command{
    private Device device;

    public ChannelCommand(Device device) {
        this.device = device;
    }

    @Override
    public void exe() {
        device.channelUp();
    }

    @Override
    public void unexe() {
        device.channelDown();
    }
}
