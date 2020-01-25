package com.blackcat.java.bean;

import com.blackcat.java.common.User;

/**
 * <p> ：
 *
 * @author : blackcat
 * @date : 2020/1/21 13:20
 */
public class SonReflectUtils extends FatherReflectUtils<User>{
    public static void main(String[] args) {
        SonReflectUtils j = new SonReflectUtils();
        try {
            j.getTClass();
            j.getTInstance();
        }catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
