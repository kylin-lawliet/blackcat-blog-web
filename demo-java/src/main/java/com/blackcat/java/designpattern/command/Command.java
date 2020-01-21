package com.blackcat.java.designpattern.command;

/**
 * 命令
 * @author: blackcat
 * @date: 2019/12/29 9:18
 */
public interface  Command {

    // 执行命令操作
    void exe();

    // 反执行命令操作
    void unexe();
}
