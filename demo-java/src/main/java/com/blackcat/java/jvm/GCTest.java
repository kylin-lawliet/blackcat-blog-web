package com.blackcat.java.jvm;

/**
 * <p> 描述 ：GC测试
 * @author : blackcat
 * @date : 2020/1/24 13:44
 * -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+PrintGCTimeStamps
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] test1 = new byte[30231*1024];
        byte[] test2 = new byte[9900*1024];
        byte[] test3 = new byte[9900*1024];
        byte[] test4 = new byte[9900*1024];
        byte[] test5 = new byte[9900*1024];
        byte[] test6 = new byte[9900*1024];

//        byte[] test1,test2,test3,test4;
//        test1 = new byte[30231*1024];

    }
}
