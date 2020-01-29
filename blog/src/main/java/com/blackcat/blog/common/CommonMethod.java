package com.blackcat.blog.common;

/**
 * <p> ：公共方法
 * @author : blackcat
 * @date : 2020/1/20 17:25
 */
public class CommonMethod {

    /**
     * <p> : sql返回结果
     * @author : blackcat
     * @date : 2020/1/20 17:25
     * @param [result]
     * @return boolean
    */
    public static boolean retBool(Integer result) {
        return null != result && result >= 1;
    }
}
