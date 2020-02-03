package com.blackcat.shiro.config;

import com.blackcat.shiro.tag.CustomTag;
import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p> ：freemarker配置类
 * @author : blackcat
 * @date : 2020/1/17 13:52
 */
@Configuration
public class FreeMarkerConfig {

    @Resource
    protected freemarker.template.Configuration configuration;

    @Resource
    protected CustomTag customTag;

    /**
     * <p> 添加自定义标签
     * @author : blackcat
     * @date : 2020/1/17 13:53
    */
    @PostConstruct
    public void setSharedVariable() {
        // 自定义标签
        configuration.setSharedVariable("blog", customTag);
        // shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
