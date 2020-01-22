package com.blackcat.java.designpattern.adapter;

/**
 * 两项插头接口
 * @author :    blackcat
 * @serialData : 2019/11/21 10:58
 * 设计模式-适配器 示例
*/
public interface DualPin {

    /**
     * 通电
     * @author:     blackcat
     * @serialData : 2019/11/21 10:59
     * @param [l:火线live, n:零线null]
    */
    void electrify(int l, int n);
}
