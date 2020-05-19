package com.blackcat.blog.common.tag;

import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.service.BlogMessageService;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.util.RedisUtil;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    @Resource
    private BlogArticleService iBlogArticleService;
    @Resource
    private BlogMessageService iBlogMessageService;
    @Resource
    private RedisUtil redisUtil;

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
                        String id = map.get(MethodAttribute.CODES_CODE_ID).toString();
                        if(redisUtil.hasKey(RedisKey.CODE_LIST_SUBLIST+id)){
                            environment.setVariable("codes", builder.build().wrap(redisUtil.get(RedisKey.CODE_LIST_SUBLIST+id, BlogCode.class)));
                        }else{
                            environment.setVariable("codes", builder.build().wrap(iBlogCodeService.getParents(id)));
                        }
                    }
                    break;
                case "articleTop":
                    // 热门文章
                    if(redisUtil.hasKey(RedisKey.ARTICLE_TOP)){
                        environment.setVariable("articleTop",builder.build().wrap(redisUtil.get(RedisKey.ARTICLE_TOP, BlogArticle.class)));
                    }else{
                        environment.setVariable("articleTop", builder.build().wrap(iBlogArticleService.getTop()));
                    }
                    break;
                case "menus":
                    // 用户菜单
                    Integer userId ;
                    if (mapContainsKey(map,MethodAttribute.MENUS_USER_ID)) {
                        userId = Integer.parseInt(map.get(MethodAttribute.MENUS_USER_ID).toString());
                        Map<String, Object> params = new HashMap<>(2);
                        params.put("type", "menu");
                        params.put("userId", userId);
                        // 获取用户的资源列表
                        environment.setVariable("menus", builder.build().wrap(sysMenuService.listUserMenu(params)));
                    }
                    break;
                case "messages":
                    // 获取消息通知
                    Subject subject = SecurityUtils.getSubject();
                    SysUser sysUser= (SysUser) subject.getPrincipal();
                    Map<String, Object> params = new HashMap<>(2);
                    params.put("userId", sysUser.getId());
                    params.put("status", 0);
                    environment.setVariable("messages", builder.build().wrap(iBlogMessageService.findAllByCondition(params)));
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
