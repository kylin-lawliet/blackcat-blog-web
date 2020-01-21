package com.blackcat.java.designpattern.template;

/**
 * 哺乳动物
 * FileName: Mammal
 * @author :   blackcat
 * @date :     2019/11/25 16:02
 * 设计模式-模板方法 示例二
 */
public abstract class Mammal {

    /**
     * 喂奶
     * @author:     blackcat
     * @date : 2019/11/25 17:44
     * @Param []
     * 既然是哺乳动物当然会喂奶了，但这里约束为只能母的喂奶
    */
    protected final void feedMilk(){
        if(true) {//如果是母的……
            System.out.println("喂奶");
        }else {//如果是公的……或者可以抛个异常出去
            System.out.println("公的不会");
        }
    }

    /**
     * 移动
     * @author:     blackcat
     * @date : 2019/11/25 17:45
     * @Param []
     * 哺乳动物当然可以移动，但具体怎么移动还不知道。
    */
    public abstract void move();
}
