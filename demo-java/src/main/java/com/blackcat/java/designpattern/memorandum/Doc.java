package com.blackcat.java.designpattern.memorandum;

/**
 * 文档
 * @author: blackcat
 * @date: 2019/12/16 15:19
 * 设计模式_备忘录  示例
 */
public class Doc {
    private String title;// 文章标题
    private String body;// 文章内容

    // 新建文档先命名
    public Doc(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //设计模式优化后代码
    public History createHistory() {
        return new History(body);//创建历史记录
    }
    public void restoreHistory(History history){
        this.body = history.getBody();//恢复历史记录
    }
}
