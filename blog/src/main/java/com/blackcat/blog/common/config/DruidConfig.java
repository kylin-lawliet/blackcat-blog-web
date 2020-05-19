package com.blackcat.blog.common.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.blackcat.blog.common.property.Druid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p> 描述 : Druid Monitor 配置
 * @author : blackcat
 * @date  : 2020/4/12 17:09
*/
@Configuration
public class DruidConfig {

    @Autowired
    private Druid druid;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), druid.getServletPath());

        // IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        List<String> denyIps = druid.getDenyIps();
        if(!CollectionUtils.isEmpty(denyIps)){
            bean.addInitParameter("deny", StringUtils.collectionToDelimitedString(denyIps, ","));
        }

        // IP白名单
        List<String> allowIps = druid.getAllowIps();
        if(!CollectionUtils.isEmpty(allowIps)){
            bean.addInitParameter("allow", StringUtils.collectionToDelimitedString(allowIps, ","));
        }

        // 登录查看信息的账号密码.
        bean.addInitParameter("loginUsername", druid.getUsername());
        bean.addInitParameter("loginPassword", druid.getPassword());
        // 禁用HTML页面上的"Reset All"功能（默认false）
        bean.addInitParameter("resetEnable", String.valueOf(druid.getResetEnable()));
        return bean;
    }

    /**
     * Druid的StatFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        bean.addUrlPatterns("/*");
        // 排除的url
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}
