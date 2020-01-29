package com.blackcat.mybatis.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.*;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;

import java.util.Properties;

/**
 * <p> ：Mybatis-Plus配置类
 * @author : blackcat
 * @date : 2020/1/18 12:44
 * LogicSqlInjector  在 mybatisplus 3.0.1 中
 */
@Configuration
@MapperScan("com.blackcat.mybatis.mapper")//这个注解，作用相当于下面的@Bean MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfig {

//    /**
//     * 分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setDialectType("mysql");
//        return paginationInterceptor;
//    }
//
//    /**
//     * sql注入器  逻辑删除插件
//     *
//     * @return
//     */
//    @Bean
//    public ISqlInjector iSqlInjector() {
//        return new LogicSqlInjector();
//    }
//
//    /**
//     * sql性能分析插件，输出sql语句及所需时间
//     *
//     * @return
//     */
//    @Bean
//    @Profile({"dev", "test"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }
//
//    /**
//     * 配置mybatis的分页插件pageHelper
//     * @return
//     */
//    @Bean
//    public PageHelper pageHelper() {
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("dialect", "mysql");
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
//
//    /**
//     * 乐观锁插件
//     *
//     * @return
//     */
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
}
