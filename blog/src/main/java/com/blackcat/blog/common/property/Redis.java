package com.blackcat.blog.common.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p> 描述 : redis属性配置文件
 * @author : blackcat
 * @date  : 2020/2/2 11:36
*/
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "spring.redis")
@Data
@EqualsAndHashCode(callSuper = false)
@Order(-1)
public class Redis {
    private Integer database;
    private String host;
    private Integer port;
    private String password;
    private Integer timeout;
    /**
     * 默认30天 = 2592000s
     */
    private Integer expire = 2592000;

}
