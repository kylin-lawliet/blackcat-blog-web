package com.blackcat.java.designpattern.agent;

/**
 * 调制解调器
 * @author: blackcat
 * @date: 2019/12/18 10:01
 * 设计模式-代理 示例
 */
public class Modem implements Internet{

    // 实现互联网访问接口
    @Override
    public void access(String url) {
        System.out.println("正在访问：" + url);
    }
}
