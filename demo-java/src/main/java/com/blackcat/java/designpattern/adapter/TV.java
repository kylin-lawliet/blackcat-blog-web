package com.blackcat.java.designpattern.adapter;

/**
 * 电视机
 * FileName: TV
 * @author :   blackcat
 * @Date:     2019/11/21 11:00
 * 设计模式-适配器 示例
 */
public class TV implements DualPin {

    @Override
    public void electrify(int l, int n) {
        System.out.println("火线通电：" + l);
        System.out.println("零线通电：" + n);
    }
}
