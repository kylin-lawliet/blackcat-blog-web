package com.blackcat.java.designpattern.template;

/**
 * 软件项目管理
 * FileName: PM
 * @author :   blackcat
 * @date :     2019/11/25 17:49
 * 设计模式-模板方法 示例三
 */
public abstract class PM {

    protected abstract void analyze();//需求分析
    protected abstract void design();//设计
    protected abstract void develop();//开发
    protected abstract boolean test();//测试
    protected abstract void release();//发布

    /**
     * 任务流程
     * @author:     blackcat
     * @date : 2019/11/25 17:51
     * @Param []
    */
    protected final void kickoff(){
        analyze();
        design();
        do {
                 develop();
        } while (!test());//如果测试失败，则继续开发改Bug。
        release();
    }
}
