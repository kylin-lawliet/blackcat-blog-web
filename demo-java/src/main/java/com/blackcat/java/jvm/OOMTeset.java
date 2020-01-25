package com.blackcat.java.jvm;

import com.blackcat.java.common.User;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 描述 ：finalize()方法最终判定对象是否存活
 * @author : blackcat
 * @date : 2020/1/24 15:34
 */
public class OOMTeset {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0, j = 0;
        while (true) {
            list.add(new User());
        }
    }
}
