package com.blackcat.java.designpattern.responsibility;

/**
 * 审批人抽象类
 * @author: blackcat
 * @date: 2019/12/17 9:27
 * 设计模式-责任链 示例
 */
public abstract  class Approver {
    protected String name;// 抽象出审批人的姓名。
    protected Approver nextApprover;// 下一个审批人，更高级别领导。

    public Approver(String name) {
        this.name = name;
    }

    protected Approver setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
        return this.nextApprover;// 返回下个审批人，链式编程。
    }

    public abstract void approve(int amount);// 抽象审批方法由具体审批人子类实现
}
