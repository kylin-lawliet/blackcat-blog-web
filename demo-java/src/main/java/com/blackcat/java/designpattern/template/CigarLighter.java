package com.blackcat.java.designpattern.template;

/**
 * 点烟器的实现
 * FileName: CigarLighter
 * @author :   blackcat
 * @date :     2019/11/25 15:58
 * 设计模式-模板方法 示例一
 */
public class CigarLighter implements CigarLighterInterface{

    @Override
    public void electrifyDC16V() {
        int time = 1000;
        while(--time>0){
            System.out.println("加热电炉丝");
        }
        System.out.println("点烟器弹出");
    }
}
