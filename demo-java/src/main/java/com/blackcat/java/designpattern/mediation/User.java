package com.blackcat.java.designpattern.mediation;

/**
 * FileName: User
 * @author :   blackcat
 * @date :     2019/11/29 12:48
 * 设计模式-中介 优化代码示例
 */
public class User {

    private String name;//名字
    private ChatRoom chatRoom;//聊天室引用

    public User(String name) {
        this.name = name;//初始化必须起名字
    }

    public String getName() {
        return this.name;
    }

    public void login(ChatRoom chatRoom) {//用户登陆
        chatRoom.connect(this);//调用聊天室连接方法
        this.chatRoom = chatRoom;//注入聊天室引用
    }

    public void talk(String msg) {//用户发言
        chatRoom.sendMsg(this, msg);//给聊天室发消息
    }

    public void listen(User fromWhom, String msg) {//且听风吟
        System.out.print("【"+this.name+"的对话框】");
        System.out.println(fromWhom.getName() + " 说： " + msg);
    }
}
