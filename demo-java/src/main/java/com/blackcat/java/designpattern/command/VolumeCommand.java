package com.blackcat.java.designpattern.command;

/**
 * 音量
 * @author: blackcat
 * @date: 2019/12/29 9:20
 */
public class VolumeCommand implements Command{

    private Device device;

    public VolumeCommand(Device device) {
        this.device = device;
    }

    @Override
    public void exe() {
        device.volumeUp();
    }

    @Override
    public void unexe() {
        device.volumeDown();
    }
}
