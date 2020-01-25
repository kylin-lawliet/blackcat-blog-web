package com.blackcat.blog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * <p> : Mybatis-Plus 配置类
 * @author : blackcat
 * @date : 2020/1/18 14:06
*/
@Component
@MapperScan("com.blackcat.blog.core.mapper") //扫描Mapper
public class MybatisConfig {

}
