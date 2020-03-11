package com.blackcat.blog.common.config;

import com.blackcat.blog.common.tag.CustomTag;
import com.blackcat.blog.util.FormatTimeFTLHelper;
import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <p> ：freemarker配置类
 * @author : blackcat
 * @date : 2020/1/17 13:52
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
     * @date : 2020/1/17 13:53
    */
    @PostConstruct
    public void setSharedVariable() {
        // 自定义标签
        configuration.setSharedVariable("blog", customTag);
        // shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
        // 设定在页面使用的标签的类型 (([]、<>),[]这种标记解析要快些)
        configuration.setTagSyntax(freemarker.template.Configuration.AUTO_DETECT_TAG_SYNTAX);
        // 日期格式化标签
        configuration.setSharedVariable("formatTime", new FormatTimeFTLHelper());
    }
}
