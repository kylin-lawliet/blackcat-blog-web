package com.blackcat.java.designpattern.mediation;

/**
 * FileName: Main
 * @author :   blackcat
 * @date :     2019/11/29 12:45
 * 设计模式-中介 简单代码示例
 */
public class Main {

    public static void main(String[] args) {
        People people1 = new People("张三");
        People people2 = new People("李四");
        people1.connect(people2);
        people2.connect(people1);
        people1.talk("你好。");
        people2.talk("早上好，三哥。");

        ChatRoom chatRoom = new ChatRoom("临时聊天室");
        User user = new User("张三");
        user.login(chatRoom);

        User user2 = new User("李四");
        user2.login(chatRoom);

        User user3= new User("赵五");
        user3.login(chatRoom);

        user.talk("我张三来了");
        user2.talk("我李四来了");
        user3.talk("我赵五来了");
    }
}
