package com.blackcat.java.designpattern.memorandum;

import java.util.ArrayList;
import java.util.List;

/**
 * 编辑器
 * @author: blackcat
 * @date: 2019/12/16 15:21
 * 设计模式_备忘录  示例
 */
public class Editor {
    private Doc doc;// 文档引用

    private List<History> historyRecords;// 历史记录列表
    private int historyPosition = -1;// 历史记录当前位置

    public Editor(Doc doc) {
        System.out.println("<<<打开文档" + doc.getTitle());
        this.doc = doc;
        historyRecords = new ArrayList<>();// 初始化历史记录
        backup();// 保存一份历史记录
        show();//显示内容
    }

    // 保存一份历史记录
    private void  backup() {
        historyRecords.add(doc.createHistory());
        historyPosition++;
    }

    // 撤销操作：如按下Ctr+Z，回到过去。
    public void undo(){
        System.out.println(">>>撤销操作");
        if (historyPosition==0) {
            return;//到头了，不能再撤销了。
        }
        historyPosition--;
        History history = historyRecords.get(historyPosition);
        doc.restoreHistory(history);
        show();
    }

    public void append(String txt) {
        System.out.println("<<<插入操作");
        if (doc.getBody() == null) {
            doc.setBody(txt);
        } else {
            doc.setBody(doc.getBody()+txt);
        }
        backup();//操作完成后保存历史记录
        show();
    }

    public void save() {
        System.out.println("<<<存盘操作");
    }

    public void delete() {
        System.out.println("<<<删除操作");
        doc.setBody("");
        backup();//操作完成后保存历史记录
        show();
    }

    // 显示当前文本内容
    private void show() {
        if(doc.getBody()!=null){
            System.out.println(doc.getBody());
        }
        System.out.println("文章结束>>>\n");
    }
}
