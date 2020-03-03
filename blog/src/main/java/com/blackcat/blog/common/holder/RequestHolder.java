package com.blackcat.blog.common.holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * <p> 描述 : Request
 * @author : blackcat
 * @date  : 2020/2/14
*/
public class RequestHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHolder.class);

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        LOGGER.debug("getRequest -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取Response
     */
    public static HttpServletResponse getResponse() {
        LOGGER.debug("getResponse -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        LOGGER.debug("getSession -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return getRequest().getSession();
    }

    /**
     * 获取session的Attribute
     * @param name session的key
     */
    public static Object getSession(String name) {
        LOGGER.debug("getSession -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return (RequestContextHolder.getRequestAttributes()).getAttribute(name, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 添加session
     */
    public static void setSession(String name, Object value) {
        LOGGER.debug("setSession -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        (RequestContextHolder.getRequestAttributes()).setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 清除指定session
     */
    public static void removeSession(String name) {
        LOGGER.debug("removeSession -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        (RequestContextHolder.getRequestAttributes()).removeAttribute(name, RequestAttributes.SCOPE_SESSION);
    }

    /**
     * 获取所有session key
     */
    public static String[] getSessionKeys() {
        LOGGER.debug("getSessionKeys -- Thread id :{}, name : {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return (RequestContextHolder.getRequestAttributes()).getAttributeNames(RequestAttributes.SCOPE_SESSION);
    }
}
