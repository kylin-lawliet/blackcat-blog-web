package com.blackcat.java.designpattern.responsibility;

/**
 * 经理
 * @author: blackcat
 * @date: 2019/12/17 9:20
 * 设计模式-责任链 示例
 */
public class Manager extends Approver{
//    private String name;

    public Manager(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 5000) {
            System.out.println("审批通过。【经理：" + name + "】");
        } else {
            System.out.println("无权审批，升级处理。【经理：" + name + "】");
            this.nextApprover.approve(amount);
        }
    }

    /*public boolean approve(int amount){
        if (amount <= 1000) {
            System.out.println("审批通过。【经理：" + name + "】");
            return true;
        } else {
            System.out.println("无权审批，请找上级。【员工：" + name + "】");
            return false;
        }
    }*/
}
