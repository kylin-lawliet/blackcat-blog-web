package com.blackcat.java.designpattern.iteration;

import java.util.Iterator;

/**
 * 行车记录仪
 * @author: blackcat
 * @date: 2019/12/13 13:33
 * 设计模式-迭代器 示例
 */
public class DrivingRecorder {
    private int index = -1;// 当前记录位置
    private String[] records = new String[10];// 假设只能记录10条视频

    public void append(String record){
        // 循环覆盖
        if (index == 9) {
            index = 0;
        } else {
            index++;
        }
        records[index] = record;
    }

    public void display(){
        // 循环数组并显示所有10条记录
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + records[i]);
        }
    }

    public void displayInOrder() {
        // 按顺序从新到旧显示10条记录
        for (int i = index, loopCount = 0; loopCount < 10; i = i == 0 ? i = 9 : i - 1, loopCount++) {
            System.out.println(records[i]);
        }
    }

    // 设计模式优化代码
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        int cursor = index;// 迭代器游标，不染指原始游标。
        int loopCount = 0;

        @Override
        public boolean hasNext() {
            return loopCount < 10;
        }

        @Override
        public String next() {
            int i = cursor;// 记录即将返回的游标位置
            if (cursor == 0) {
                cursor = 9;
            } else {
                cursor--;
            }
            loopCount++;
            return records[i];
        }
    }
}
