package com.blackcat.blog.common.exception;

/**
 * <p> 描述 ：
 * @author : blackcat
 * @date : 2020/1/25 17:10
 */
public class BlogException  extends RuntimeException{

    public BlogException(String message) {
        super(message);
    }

    public BlogException() {
        super();
    }

    public BlogException(String message, Throwable cause) {
        super(message, cause);
    }
}
