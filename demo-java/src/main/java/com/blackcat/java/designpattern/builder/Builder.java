package com.blackcat.java.designpattern.builder;

/**
 * 施工方接口
 * @author: blackcat
 * @date: 2019/12/27 10:46
 * 设计模式-建造者 示例
 */
interface Builder {

    void buildBasement();

    void buildWall();

    void buildRoof();

    Building getBuilding();
}
