package com.blackcat.java.designpattern.adapter;

/**
 * 类适配器
 * FileName: ClassAdapter
 * @author :   blackcat
 * @serialData :     2019/11/21 11:06
 * 设计模式-适配器 示例
 * 对象组合
 * 缺点:这适配器继承为TV专用了，像是洗衣机就用不了
 */
public class ClassAdapter extends TV implements TriplePin{

    @Override
    public void electrify(int l, int n, int e) {
        super.electrify(l, n);
    }
}
