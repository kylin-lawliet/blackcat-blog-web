package com.blackcat.blog.common.tag;

import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.CodeKey;
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
            // 标签属性
            switch (method) {
                case "availableMenus":
                    // 获取所有可用的菜单资源 添加资源 父级选项
                    environment.setVariable("availableMenus", builder.build().wrap(sysMenuService.listAllAvailableMenu()));
                    break;
                case "codes":
                    // 获取所有可用的总码表分类
                    if(mapContainsKey(map,MethodAttribute.CODES_CODE_ID)){
                        environment.setVariable("codes", builder.build().wrap(iBlogCodeService.getParents(Long.parseLong(map.get(MethodAttribute.CODES_CODE_ID).toString()))));
                    }
                    break;
                case "articleTypes":
                    // 获取所有可用的博客分类分类
                    environment.setVariable("codes", builder.build().wrap(iBlogCodeService.getParents(Long.parseLong(CodeKey.ARTICLE_TYPE))));
                    break;
                case "menus":
                    // 用户菜单
                    Integer userId = null;
                    if (mapContainsKey(map,MethodAttribute.MENUS_USER_ID)) {
                        userId = Integer.parseInt(map.get(MethodAttribute.MENUS_USER_ID).toString());
                        Map<String, Object> params = new HashMap<>(2);
                        params.put("type", "menu");
                        params.put("userId", userId);
                        // 获取用户的资源列表
                        environment.setVariable("menus", builder.build().wrap(sysMenuService.listUserMenu(params)));
                    }
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }

    /**
     * <p> 描述 : 判断map是否包含某个可以并且值不为空
     * @author : blackcat
     * @date  : 2020/2/29 17:56
    */
    private boolean mapContainsKey(Map map,String key){
        if(map.containsKey(key)&&!StringUtils.isEmpty(map.get(key).toString())){
            return true;
        }
        return false;
    }
}
