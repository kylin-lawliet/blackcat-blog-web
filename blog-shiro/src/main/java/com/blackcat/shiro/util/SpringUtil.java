package com.blackcat.shiro.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p> ：Spring上下文工具类
 * @author : blackcat
 * @date : 2020/1/14 12:52
 */
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context;
    /**
     * <p> Spring在bean初始化后会判断是不是ApplicationContextAware的子类
     * <p> 如果该类是setApplicationContext()方法,会将容器中ApplicationContext作为参数传入进去
     * @author: blackcat
     * @date: 2020/1/14 13:26
     * @Param [applicationContext]
     * @return void
    */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    /**
     * <p> 通过Name返回指定的Bean
     * @author: blackcat
     * @date: 2020/1/14 13:26
     * @Param [beanClass]
     * @return T
    */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
