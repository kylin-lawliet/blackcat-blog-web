package com.blackcat.blog.common.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p> 描述 : druid属性
 * @author : blackcat
 * @date  : 2020/2/3 16:43
*/
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "blog.druid")
@Data
@EqualsAndHashCode(callSuper = false)
@Order(-1)
public class DruidProperties {
    private String username;
    private String password;
    private String servletPath = "/druid/*";
    private Boolean resetEnable = false;
    private List<String> allowIps;
    private List<String> denyIps;
}
