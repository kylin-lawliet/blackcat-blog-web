package com.blackcat.java.designpattern.agent;

/**
 * 交换机
 * @author: blackcat
 * @date: 2019/12/18 10:37
 */
public class Switch implements Intranet {

    @Override
    public void fileAccess(String path) {
        System.out.println("访问内网：" + path);
    }
}
