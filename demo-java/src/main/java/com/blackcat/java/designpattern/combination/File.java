package com.blackcat.java.designpattern.combination;

/**
 * 文件
 * FileName: File
 * @author :   blackcat
 * @serialData :     2019/12/1 10:14
 * 设计模式-组合 示例
 */
public class File extends Node{

    public File(String name) {
        super(name);//调用父类“节点”的构造方法命名。
    }

    @Override
    protected void add(Node child) {
        System.out.println("不能添加子节点。");
    }

    @Override
    public void ls(int space){
        super.ls(space);
    }
}
