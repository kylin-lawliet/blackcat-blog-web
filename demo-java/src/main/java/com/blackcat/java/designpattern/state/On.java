package com.blackcat.java.designpattern.state;

/**
 * FileName: On
 * @author :   blackcat
 * @date :     2019/11/22 16:25
 */
public class On implements State {

    @Override
    public void switchOn(Switcher switcher) {
        System.out.println("WARN!!!通电状态无需再开");
    }

    @Override
    public void switchOff(Switcher switcher) {
        switcher.setState(new Off());
        System.out.println("OK...灯灭");
    }
}
