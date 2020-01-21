package com.blackcat.java.designpattern.agent;

import java.util.Arrays;
import java.util.List;

/**
 * 路由器代理类
 * @author: blackcat
 * @date: 2019/12/18 10:05
 * 设计模式-代理 示例
 */
public class RouterProxy implements Internet {
    private Internet modem;
    private List<String> blackList = Arrays.asList("电影", "游戏", "音乐", "小说");

    public RouterProxy() {
        this.modem = new Modem();//实例化被代理类
        System.out.println("拨号上网...连接成功！");
    }

    @Override
    public void access(String url) {
        for (String keyword : blackList) {//循环黑名单
            if (url.contains(keyword)) {//是否包含黑名单字眼
                System.out.println("禁止访问：" + url);
                return;
            }
        }
        modem.access(url);//正常访问互联网
    }
}
