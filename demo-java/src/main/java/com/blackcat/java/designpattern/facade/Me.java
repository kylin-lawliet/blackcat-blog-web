package com.blackcat.java.designpattern.facade;

/**
 * FileName: Me
 * @author :   blackcat
 * @date :     2019/11/28 11:13
 * 设计模式-门面 示例
 */
public class Me {

    public void eat(){
        System.out.println("我只会吃。。。");
    }

    public static void main(String[] args) {
        //找菜贩子买菜
        VegVendor vv = new VegVendor();
        vv.sell();
        //找女友做饭
        GirlFriend gf = new GirlFriend();
        gf.cook();
        //我只会吃
        Me me = new Me();
        me.eat();
        //谁洗碗呢？一场战场一触即发……
    }
}
