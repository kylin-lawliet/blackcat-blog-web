package com.blackcat.blog.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

/**
 * <p> 描述 : Shiro 配置
 * @author : blackcat
 * @date  : 2020/2/1 12:46
*/
@Configuration
public class ShiroConfig {

    @Resource
    private SysMenuService sysMenuService;
//    @Resource
//    private RedisProperties redisProperties;

    /**
     * <p> 描述 : 处理拦截资源
     * @author : blackcat
     * @date  : 2020/2/1 12:51
     * @param securityManager 安全管理器
     * Shiro内置的FilterChain
     *  anon:  所有url都都可以匿名访问;
     *  authc: 需要认证才能进行访问;
     *  user:  配置记住我或认证通过可以访问。
    */
    @Bean(name = "shirFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager,Shiro的核心安全接口
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 这里的/login是后台的接口名,非页面，如果不设置默认会自动寻找Web工程根目录下的"/login.ftl"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 这里的/index是后台的接口名,非页面,登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/403");

        // 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 一定要注意顺序,否则就不好使了
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
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

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * <p> 描述 : 配置核心安全事务管理器
     * @author : blackcat
     * @date  : 2020/2/4 16:37
    */
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置自定义realm.
        securityManager.setRealm(shiroRealm);

        //配置记住我
        securityManager.setRememberMeManager(rememberMeManager());

        //配置 redis缓存管理器
//        securityManager.setCacheManager(redisCacheManager());

        //配置自定义session管理，使用redis
//        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * <p> 描述 : 身份认证realm
     * @author : blackcat
     * @date  : 2020/2/4 16:37
    */
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
//        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        return shiroRealm;
    }

    /**
     * <p> 描述 : 可以将某个方法或者某个具体的类的静态方法进行调用
     * 详情参看 : https://blog.csdn.net/u012881904/article/details/77531689
     * @author : blackcat
     * @date  : 2020/2/3 16:19
    */
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager){
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(securityManager);
        return bean;
    }

    /**
     * <p> 描述 : 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     *  配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @author : blackcat
     * @date  : 2020/2/3 16:59
    */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * <p> 描述 : 开启shiro aop注解支持.
     * 可以在controller中的方法前加上注解 如 @RequiresPermissions("user:add")
     * @author : blackcat
     * @date  : 2020/2/2 10:21
    */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * <p> 描述 : 解决： 无权限页面不跳转 shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized") 无效
     * @author : blackcat
     * @date  : 2020/2/4 16:38
    */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
        Properties properties=new Properties();
        //这里的 /unauthorized 是页面，不是访问的路径
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/error/403");
        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException","/error/403");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }


    /**
     * <p> 描述 : cookie对象;会话Cookie模板 ,默认为: JSESSIONID
     * 问题: 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
     * @author : blackcat
     * @date  : 2020/2/6 13:25
    */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    /**
     * <p> 描述 : cookie管理对象;记住我功能,rememberMe管理器
     * @author : blackcat
     * @date  : 2020/2/6 13:25
    */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }



}
