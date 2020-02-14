package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackcat.blog.common.holder.SpringContextHolder;
import com.blackcat.blog.common.shiro.ShiroRealm;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.ShiroService;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 描述 : Shiro-权限相关的业务处理
 * @author : blackcat
 * @date  : 2020/2/8 16:28
*/
@Slf4j
@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysUserService userService;

    /**
     * <p> 描述 : 初始化权限
     * @author : blackcat
     * @date  : 2020/2/10 13:04
    */
    @Override
    public Map<String, String> loadFilterChainDefinitions() {
        /*
            配置访问权限
            - anon:所有url都都可以匿名访问
            - authc: 需要认证才能进行访问（此处指所有非匿名的路径都需要登陆才能访问）
            - user:配置记住我或认证通过可以访问
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不登录可以访问的资源，anon 表示资源都可以匿名访问
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 错误页面
        filterChainDefinitionMap.put("/error", "anon");
        // 静态资源
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/ztree/**", "anon");
        filterChainDefinitionMap.put("/jquery/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        // logout是shiro提供的过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        // 此时访问/userInfo/del需要del权限,在自定义Realm中为用户授权。
        // filterChainDefinitionMap.put("/userInfo/del", "perms["userInfo:del"]");

        // 加载数据库中配置的资源权限列表
        List<SysMenu> list = sysMenuService.list(
                new QueryWrapper<SysMenu>().isNotNull("url").orderByAsc("sort")
        );
        list.forEach(menu -> {
            if (StringUtils.isNotBlank(menu.getUrl()) && StringUtils.isNotBlank(menu.getPermission())) {
                String permission = "perms[" + menu.getPermission() + "]";
                filterChainDefinitionMap.put(menu.getUrl(), permission);
            }
        });

        // 其他资源都需要认证
        filterChainDefinitionMap.put("/**", "user");
        return filterChainDefinitionMap;
    }

    /**
     * <p> 描述 : 重新加载权限
     * @author : blackcat
     * @date  : 2020/2/10 13:03
    */
    @Override
    public void updatePermission() {
        ShiroFilterFactoryBean shirFilter = SpringContextHolder.getBean(ShiroFilterFactoryBean.class);
        synchronized (shirFilter) {
            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shirFilter.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shirFilter.getFilterChainDefinitionMap().clear();
            shirFilter.setFilterChainDefinitionMap(loadFilterChainDefinitions());
            // 重新构建生成
            Map<String, String> chains = shirFilter.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }

    /**
     * <p> 描述 : 重新加载用户权限
     * @author : blackcat
     * @date  : 2020/2/10 13:03
    */
    @Override
    public void reloadAuthorizingByUserId(SysUser user) {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) rsm.getRealms().iterator().next();
        Subject subject = SecurityUtils.getSubject();
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(user, realmName);
        subject.runAs(principals);
        shiroRealm.getAuthorizationCache().remove(subject.getPrincipals());
        subject.releaseRunAs();
        log.info("用户[{}]的权限更新成功！！", user.getUsername());
    }

    /**
     * <p> 描述 : 重新加载所有拥有roleId角色的用户的权限
     * @author : blackcat
     * @date  : 2020/2/10 13:03
    */
    @Override
    public void reloadAuthorizingByRoleId(Long roleId) {
        List<SysUser> userList = userService.listByRoleId(roleId);
        if (CollectionUtils.isEmpty(userList)) {
            return;
        }
        for (SysUser user : userList) {
            reloadAuthorizingByUserId(user);
        }
    }

}
