package com.blackcat.java.designpattern.interpreter;

import java.util.Arrays;

/**
 * @author: blackcat
 * @date: 2019/12/31 15:48
 * 设计模式-解释器 示例
 */
public class Client {
    public static void main(String[] args) {
        /*
4        * BEGIN             // 脚本开始
5        * MOVE 500,600;     // 鼠标移动到坐标(500, 600)
6        *  BEGIN LOOP 5     // 开始循环5次
7        *      LEFT_CLICK;  // 循环体内单击左键
8        *      DELAY 1;     // 每次延时1秒
9        *  END;             // 循环体结束
10       * RIGHT_DOWN;       // 按下右键
11       * DELAY 7200;       // 延时2小时
12       * END;              // 脚本结束
13       */
        Expression sequence = new Sequence(Arrays.asList(
                new Move(500, 600),
                new Repetition(
                        new Sequence(
                                Arrays.asList(new LeftClick(),
                                        new Delay(1))
                        ),
                        5
                ),
                new RightDown(),
                new Delay(7200)
        ));
        sequence.interpret();
       /* 移动鼠标：【500,600】
        按下鼠标：左键
        松开鼠标：左键
        系统延迟：1秒钟
        按下鼠标：左键
        松开鼠标：左键
        系统延迟：1秒钟
        按下鼠标：左键
        松开鼠标：左键
        系统延迟：1秒钟
        按下鼠标：左键
        松开鼠标：左键
        系统延迟：1秒钟
        按下鼠标：左键
        松开鼠标：左键
        系统延迟：1秒钟
        按下鼠标：右键
        系统延迟：7200秒钟*/
    }
}
