package com.blackcat.java.designpattern.responsibility;

/**
 * CEO
 * @author: blackcat
 * @date: 2019/12/17 9:23
 * 设计模式-责任链 示例
 */
public class CEO extends Approver{
//    private String name;

    public CEO(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 10000) {
            System.out.println("审批通过。【CEO：" + name + "】");
        } else {
            System.out.println("驳回申请。【CEO：" + name + "】");
        }
    }

    /*public boolean approve(int amount){
        if (amount <= 10000) {
            System.out.println("审批通过。【CEO：" + name + "】");
            return true;
        } else {
            System.out.println("驳回申请。【CEO：" + name + "】");
            return false;
        }
    }*/
}
