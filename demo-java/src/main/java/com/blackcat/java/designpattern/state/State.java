package com.blackcat.java.designpattern.state;

/**
 * 状态
 * @author:     blackcat
 * @date : 2019/11/22 16:24
 * @Param
 * 设计模式-状态 示例
*/
public interface State {

    void switchOn(Switcher switcher);//开
    void switchOff(Switcher switcher);//关
}
