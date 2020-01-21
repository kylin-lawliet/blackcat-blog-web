package com.blackcat.java.designpattern.facade;

/**
 * 服务员
 * FileName: Waiter
 * @author :   blackcat
 * @date :     2019/11/28 11:15
 * 设计模式-门面 示例
 */
public class Waiter {

   public void  order(){
       System.out.println("接待，入座，点菜");
   }

   public void serve(){
       System.out.println("上菜");
   }
}
