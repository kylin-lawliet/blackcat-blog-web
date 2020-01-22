package com.blackcat.java.bean;

import lombok.Data;

/**
 * <p> ：测试类
 * @author : blackcat
 * @serialData : 2020/1/21 10:45
 */
@Data
public class User extends FatherReflectUtils<User>{

    private String username;
    private String userpassword;

    public static void main(String[] args) {
        User user = new User();

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



