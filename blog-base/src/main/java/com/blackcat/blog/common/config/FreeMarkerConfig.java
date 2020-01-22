package com.blackcat.blog.common.config;

import com.blackcat.blog.common.tag.CustomTag;
import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <p> ：freemarker配置类
 * @author : blackcat
 * @serialData : 2020/1/17 13:52
 */
@Configuration
public class FreeMarkerConfig {
    @Autowired
    protected freemarker.template.Configuration configuration;

    @Autowired(required = false)
    protected CustomTag customTag;

    /**
     * <p> 添加自定义标签
     * @author : blackcat
     * @serialData : 2020/1/17 13:53
    */
    @PostConstruct
    public void setSharedVariable() {
        // 自定义标签
        configuration.setSharedVariable("blog", customTag);
        // shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
