package com.blackcat.java.designpattern.adapter;

/**
 * 三项插孔接口
 * FileName: TriplePin
 * @author :   blackcat
 * @serialData :     2019/11/21 10:55
 * 设计模式-适配器 示例
 */
public interface  TriplePin {

    /**
     * 通电
     * @author:     blackcat
     * @serialData : 2019/11/21 10:56
     * @param [l:火线live, n:零线null, e:地线earth]
    */
    void electrify(int l, int n, int e);
}
