package com.blackcat.blog.common.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * <p> : Mybatis-Plus 配置类
 * @author : blackcat
 * @date : 2020/1/18 14:06
*/
@Component
@MapperScan("com.blackcat.blog.core.mapper") //扫描Mapper
public class MybatisConfig {

    /**
     * <p> : 分页插件
     * @author : blackcat
     * @date : 2020/1/18 14:07
    */
    /*@Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }*/

    /**
     * <p> : 配置mybatis的分页插件pageHelper
     * @author : blackcat
     * @date : 2020/1/18 14:07
     */
    /*@Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }*/

    /**
     * <p> : sql注入器  逻辑删除插件
     * @author : blackcat
     * @date : 2020/1/18 14:07
     */
    /*@Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }*/

    /**
     * <p> : sql性能分析插件，输出sql语句及所需时间
     * @author : blackcat
     * @date : 2020/1/18 14:07
     */
    /*@Bean
    @Profile({"dev", "test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }*/

}
