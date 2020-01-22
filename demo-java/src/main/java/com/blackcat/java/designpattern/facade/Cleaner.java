package com.blackcat.java.designpattern.facade;

/**
 * 保洁员 洗碗
 * FileName: Cleaner
 * @author :   blackcat
 * @serialData :     2019/11/28 11:16
 * 设计模式-门面 示例
 */
public class Cleaner {

    public void clean(){
        System.out.println("收拾桌子，洗碗");
    }

    public void wash(){
        System.out.println("其他工序……");
    }
}
