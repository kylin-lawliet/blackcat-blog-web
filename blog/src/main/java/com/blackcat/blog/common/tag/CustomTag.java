package com.blackcat.blog.common.tag;

import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.service.SysMenuService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> ：自定义的freemarker标签
 * @author : blackcat
 * @date : 2020/1/17 13:53
 */
@Component
public class CustomTag implements TemplateDirectiveModel {

    private static final String METHOD_KEY = "method";
    @Autowired
    private SysMenuService sysMenuService;
    @Resource
    private BlogCodeService iBlogCodeService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            switch (method) {// 标签属性
                case "availableMenus":
                    // 获取所有可用的菜单资源 添加资源 父级选项
                    environment.setVariable("availableMenus", builder.build().wrap(sysMenuService.listAllAvailableMenu()));
                    break;
                case "codes":
                    // 获取所有可用的总码表分类
                    if(map.containsKey("codeId")&&StringUtils.isEmpty(map.get("codeId").toString())){
                        environment.setVariable("codes", builder.build().wrap(iBlogCodeService.getParents(Long.parseLong(map.get("codeId").toString()))));
                    }
                    break;
                case "menus":
                    // 用户菜单
                    Integer userId = null;
                    if (map.containsKey("userId")) {
                        String userIdStr = map.get("userId").toString();
                        if(StringUtils.isEmpty(userIdStr)){
                            return;
                        }
                        userId = Integer.parseInt(userIdStr);
                    }
                    Map<String, Object> params = new HashMap<>(2);
                    params.put("type", "menu");
                    params.put("userId", userId);
                    // 获取用户的资源列表
                    environment.setVariable("menus", builder.build().wrap(sysMenuService.listUserMenu(params)));
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}
