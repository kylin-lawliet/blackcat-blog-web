package com.blackcat.java.designpattern.responsibility;

/**
 * @author: blackcat
 * @date: 2019/12/17 9:24
 * 设计模式-责任链 示例
 */
public class Client {
    public static void main(String[] args) {

        Approver flightJohn = new Staff("张飞");
        flightJohn.setNextApprover(new Manager("关羽")).setNextApprover(new CEO("刘备"));
        // 高层接触不到也没必要接触，直接找员工张飞审批。
        flightJohn.approve(1000);
        /*审批通过。【员工：张飞】*/
        flightJohn.approve(5000);
        /*无权审批，升级处理。【员工：张飞】
        审批通过。【经理：关羽】*/
        flightJohn.approve(9000);
        /*无权审批，升级处理。【员工：张飞】
        无权审批，升级处理。【经理：关羽】
        审批通过。【CEO：刘备】*/
        flightJohn.approve(88000);
        /*无权审批，升级处理。【员工：张飞】
        无权审批，升级处理。【经理：关羽】
        驳回申请。【CEO：刘备】*/

        /*
        int amount = 10000;// 出差花费10000元
        // 先找员工张飞审批
        Staff staff = new Staff("张飞");
        if (!staff.approve(amount)) {
            //被拒，找关二爷问问。
            Manager manager = new Manager("关羽");
            if (!manager.approve(amount)) {
                //还是被拒，只能找老大了。
                CEO ceo = new CEO("刘备");
                ceo.approve(amount);
            }
        }*/
        /*无权审批，请找上级。【经理：张飞】
        无权审批，请找上级。【员工：关羽】
        审批通过。【CEO：刘备】*/
    }
}
