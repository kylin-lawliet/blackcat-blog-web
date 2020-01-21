package com.blackcat.java.designpattern.command;

/**
 * @author: blackcat
 * @date: 2019/12/29 9:08
 */
public class Client {
    public static void main(String[] args) {
        /*System.out.println("===客户端用【电线】直接操作灯泡===");
        Bulb bulb = new Bulb();
        bulb.on();
        bulb.off();*/
        /*===客户端用【电线】直接操作灯泡===
        通电，灯亮。
        断电，灯灭。*/

        /*System.out.println("===客户端用【开关】操作电器===");
        Switcher switcher = new Switcher();
        switcher.setSwitchable(new Bulb());//灯泡接入开关。
        switcher.buttonOnClick();
        switcher.buttonOffClick();
        switcher.setSwitchable(new Fan());//风扇接入开关。
        switcher.buttonOnClick();
        switcher.buttonOffClick();*/
        /*===客户端用【开关】操作电器===
        按下开……
        通电，灯亮。
        按下关……
        断电，灯灭。
        按下开……
        通电，风扇转动。
        按下关……
        断电，风扇停止。*/

        System.out.println("===客户端用【可编程式遥控器】操作电器===");
        Device tv = new TV();
        Device radio = new Radio();
        Controller controller = new Controller();

        //绑定【电视机】的【命令】到【控制器按键】
        controller.bindOKCommand(new SwitchCommand(tv));
        controller.bindVerticalCommand(new ChannelCommand(tv));//上下调台
        controller.bindHorizontalCommand(new VolumeCommand(tv));//左右调音

        controller.buttonOKHold();
        controller.buttonUpClick();
        controller.buttonUpClick();
        controller.buttonDownClick();
        controller.buttonRightClick();
        /*===客户端用【可编程式遥控器】操作电器===
        长按OK按键……电视机启动
        单击↑按键……电视机频道+
        单击↑按键……电视机频道+
        单击↓按键……电视机频道-
        单击→按键……电视机音量+*/

        //绑定【收音机】的【命令】到【控制器按键】
        controller.bindOKCommand(new SwitchCommand(radio));
        controller.bindVerticalCommand(new VolumeCommand(radio));//上下调音
        controller.bindHorizontalCommand(new ChannelCommand(radio));//左右调台

        controller.buttonOKHold();
        controller.buttonUpClick();
        controller.buttonUpClick();
        controller.buttonRightClick();
        controller.buttonDownClick();
        /*长按OK按键……收音机启动
        单击↑按键……收音机音量+
        单击↑按键……收音机音量+
        单击→按键……收音机调频+
        单击↓按键……收音机音量-*/
    }
}
