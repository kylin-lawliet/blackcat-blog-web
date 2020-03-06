package com.blackcat.blog.common.config;

import com.blackcat.blog.common.property.SiteOptions;
import com.blackcat.blog.core.entity.SysOptions;
import com.blackcat.blog.core.service.SysOptionsService;
import com.blackcat.blog.core.vo.CodeKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * <p> 描述 ：加载配置信息到系统
 * @author : blackcat
 * @date : 2020/2/28 17:45
 */
@Slf4j
@Order(2)
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    @Resource
    private SiteOptions siteOptions;
    @Resource
    private SysOptionsService sysOptionsService;

    private ServletContext servletContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("加载系统参数 ...");
        reloadOptions(true);
        log.info("加载完毕！");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * <p> 描述 : 加载系统参数
     * @author : blackcat
     * @date  : 2020/2/29 15:54
     * @param startup 是否启动进入 执行SQL文件判断使用
    */
    public void reloadOptions(boolean startup) {
        List<SysOptions> options = sysOptionsService.findAll();

        log.info("查询数据库系统系统参数 ({})...", options.size());

        Map<String, String> map = siteOptions.getOptions();
        options.forEach(opt -> {
            if (StringUtils.isNoneBlank(opt.getKeyName(), opt.getValue())) {
                map.put(opt.getKeyName(), opt.getValue());
            }
        });
        map.put(CodeKey.ARTICLE_TYPE_KEY, CodeKey.ARTICLE_TYPE);
        map.put(CodeKey.ARTICLE_TAG_KEY, CodeKey.ARTICLE_TAG);
        map.put(CodeKey.NAVIGATION_KEY, CodeKey.NAVIGATION);
        servletContext.setAttribute("options", map);
        servletContext.setAttribute("site", siteOptions);

        System.setProperty("site.location", siteOptions.getLocation());
    }
}
