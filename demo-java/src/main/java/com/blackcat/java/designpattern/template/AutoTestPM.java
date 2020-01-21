package com.blackcat.java.designpattern.template;

/**
 * 自动测试项目管理
 * FileName: AutoTestPM
 * @author :   blackcat
 * @date :     2019/11/25 17:52
 * 设计模式-模板方法 示例三
 */
public class AutoTestPM extends PM {

    @Override
    protected void analyze() {
        System.out.println("进行业务沟通，需求分析");
    }

    @Override
    protected void design() {
        System.out.println("....");
    }

    @Override
    protected void develop() {
        System.out.println("....");
    }

    @Override
    protected boolean test() {
        System.out.println("....");
        return false;
    }

    @Override
    protected void release() {
        System.out.println("....");
    }
}
