package com.blackcat.java.designpattern.singleton;

/**
 * 定义神
 * FileName: God
 * @author :   blackcat
 * @serialData :     2019/11/21 10:27
 * 设计模式-单例 示例
 */
public class God {

    /**
     * 构造方法私有化
     * @author:     blackcat
     * @serialData : 2019/11/21 10:33
     * @param []
     * 因为有默认的无参构造器！那就把构造方法改成private吧，也就是神可以自己创造自己，但别人不能。
    */
    private God(){}

    /**
     * 自有永有的神单例
     * @author:     blackcat
     * @serialData : 2019/11/21 10:35
     * @param
     * private关键字保证了上帝的私有性，不可见性，不可访问性。
     * static关键字保证上帝的静态性，他与类同在，不依赖于类的实例化就自有永有，他将在内存中永生，GC垃圾回收器也回收不了他。
     * final关键字则保证这位神是和常量，衡量，他是终极上帝，不能再改。
    */
    // private static final God god = new God(); //痴汉模式（Eager load）
    private static God god = new God();// 懒汉模式（Lazy load）


    /**
     * 请神方法公开化
     * @author:     blackcat
     * @serialData : 2019/11/21 10:37
     * @param []
     * 静态方法main()，不需要实例化类就能运行的入口，同样我们需要一个静态方法getInstance()来请神
     * synchronized 解决多线程下并发请神
     */
    public static synchronized  God getInstance() {//庙是开放的不用排队进入
        //懒汉模式下加入以下代码
        if (god == null) {//如果头柱香未产生，这批抢香人进入堂内排队。
            synchronized (God.class) {
                if (god == null) {//只有头香造了神，其他抢香的白排队了
                    god = new God();
                }
            }
        }
        return god;
    }


}
