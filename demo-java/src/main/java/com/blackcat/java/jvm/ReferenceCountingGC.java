package com.blackcat.java.jvm;

/**
 * <p> 描述 ：引用计数法
 * @author : blackcat
 * @date : 2020/1/24 15:02
 */
public class ReferenceCountingGC {
    Object object = null;
    public static void main(String[] args) {
        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();
        obj1.object = obj2;
        obj2.object = obj1;
        obj1 = null;
        obj2 = null;
        /*obj1 和 obj2 相互引用着对方之外，这两个对象之间再无任何引用。
        但是他们因为互相引用对方，导致它们的引用计数器都不为0，
        于是引用计数算法无法通知 GC 回收器回收他们。*/
    }
}
