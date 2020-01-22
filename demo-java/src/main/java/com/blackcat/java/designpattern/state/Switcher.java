package com.blackcat.java.designpattern.state;

/**
 * 开关
 * FileName: Switcher
 * @author :   blackcat
 * @serialData :     2019/11/22 16:10
 * 设计模式-状态 示例
 */
public class Switcher {
    private State state = new Off();

    public void setState(State state) {
        this.state = state;
    }

    // 这里调用的是当前状态的开方法
    public void switchOn(){
        state.switchOn(this);
    }

    // 这里调用的是当前状态的关方法
    public void switchOff(){
        state.switchOff(this);
    }

    // 最简单设计(不可取设计)
    /*public void switchOn() {
        state = !state;
        System.out.println("OK...灯亮");
    }
    public void switchOff(){
        state = !state;
        System.out.println("OK...灯灭");
    }*/

    // 不推荐设计
    // false代表关，true代表开 初始状态是关
    // private boolean state=false;
    /*public void switchOn() {
        if (state == false) {//当前是关状态
            state = true;
            System.out.println("OK...灯亮");
        }else{//当前是开状态
            System.out.println("WARN!!!通电状态无需再开");
        }
    }
    public void switchOff(){
        if (state == true) {//当前是开状态
            state = false;
            System.out.println("OK...灯灭");
        }else{//当前是开状态
            System.out.println("WARN!!!断电状态无需再关");
        }
    }*/

}
