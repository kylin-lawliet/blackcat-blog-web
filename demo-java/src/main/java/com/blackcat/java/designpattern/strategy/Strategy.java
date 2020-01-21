package com.blackcat.java.designpattern.strategy;

/**
 * 算法标准
 * FileName: Strategy
 * @author :   blackcat
 * @date :     2019/11/22 10:46
 * 设计模式-策略 示例
 */
public interface Strategy {

    /**
     * 计算
     * @author:     blackcat
     * @date : 2019/11/22 10:47
     * @Param [a:操作数, b:被操作数]
    */
    int calculate(int a, int b);
}
