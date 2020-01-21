package com.blackcat.java.designpattern.agent;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author: blackcat
 * @date: 2019/12/18 10:38
 */
public class KeywordFilter implements InvocationHandler {
    private List<String> blackList = Arrays.asList("电影", "游戏", "音乐", "小说");

    private Object origin;

    public KeywordFilter(Object origin) {
        this.origin = origin;// 注入被代理对象
        System.out.println("开启关键字过滤模式...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 要被切入方法面之前的业务逻辑
        String arg = args[0].toString();
        for (String keyword : blackList) {
            if (arg.toString().contains(keyword)) {
                System.out.println("禁止访问：" + arg);
                return null;
            }
        }
        // 调用真实的被代理对象方法
        return method.invoke(origin, arg);
    }
}
