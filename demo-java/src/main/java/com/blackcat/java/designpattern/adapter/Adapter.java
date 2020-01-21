package com.blackcat.java.designpattern.adapter;

/**
 * 适配器:转换插头
 * @author :   blackcat
 * @date :     2019/11/21 11:02
 * 设计模式-适配器 示例
 * 对象适配
 */
public class Adapter implements TriplePin {

    private DualPin dualPinDevice;

    // 创建适配器地时候，需要把双插设备接入进来
    public Adapter(DualPin dualPinDevice){
        this.dualPinDevice = dualPinDevice;
    }

    // 适配器实现的是目标接口
    @Override
    public void electrify(int l, int n, int e) {
        //实际上调用了被适配设备的双插通电，地线e被丢弃了。
        dualPinDevice.electrify(l,n);
    }
}
