package com.blackcat.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.blackcat.blog.core.dao"}) //扫描DAO
public class BlogBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBaseApplication.class, args);
    }

}
