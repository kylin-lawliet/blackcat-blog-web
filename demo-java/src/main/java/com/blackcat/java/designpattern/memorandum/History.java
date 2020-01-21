package com.blackcat.java.designpattern.memorandum;

/**
 * 历史记录
 * @author: blackcat
 * @date: 2019/12/16 15:34
 * 设计模式_备忘录  示例
 */
public class History {
    private String body;//用于备忘文章内容

    public History(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
