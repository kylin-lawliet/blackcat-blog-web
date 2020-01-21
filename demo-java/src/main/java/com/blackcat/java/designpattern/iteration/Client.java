package com.blackcat.java.designpattern.iteration;

import java.util.*;

/**
 * @author: blackcat
 * @date: 2019/12/13 13:42
 * 设计模式-迭代器 示例
 */
public class Client {
    public static void main(String[] args) {
        DrivingRecorder dr = new DrivingRecorder();
        for (int i = 0; i < 12; i++) {
            dr.append("视频_" + i);
        }
        dr.display();
        /*按原始顺序显示,视频0与1分别被10与11覆盖了。
            0: 视频_10
            1: 视频_11
            2: 视频_2
            3: 视频_3
            4: 视频_4
            5: 视频_5
            6: 视频_6
            7: 视频_7
            8: 视频_8
            9: 视频_9
        */
        dr.displayInOrder();
        /*按顺序从新到旧显示
            视频_11
            视频_10
            视频_9
            视频_8
            视频_7
            视频_6
            视频_5
            视频_4
            视频_3
            视频_2
        */


        // 设计模式优化代码
        // 用户要获取交通事故视频，定义事故列表。
        List<String> accidents = new ArrayList<>();
        // 用户拿到迭代器
        Iterator<String> it = dr.iterator();
        // 如果还有下一条则继续迭代
        while (it.hasNext()) {
            String video = it.next();
            System.out.println(video);
            //用户翻看视频发现10和8可作为证据。
            if("视频_10".equals(video) || "视频_8".equals(video)){
                accidents.add(video);
            }
        }
        //拿到两个视频集accidents交给交警查看。
        System.out.println("事故证据：" + accidents);
        /*
        视频_11
        视频_10
        视频_9
        视频_8
        视频_7
        视频_6
        视频_5
        视频_4
        视频_3
        视频_2
        事故证据：[视频_10, 视频_8]
        */
    }
}
