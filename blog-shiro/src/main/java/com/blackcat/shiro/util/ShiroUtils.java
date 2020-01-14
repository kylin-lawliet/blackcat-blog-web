package com.blackcat.shiro.util;

import com.blackcat.shiro.core.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;

/**
 * <p> ： Shiro工具类
 * @author : blackcat
 * @date : 2020/1/14 13:27
 */
public class ShiroUtils {
    /** 私有构造器 **/
    private ShiroUtils(){}

    private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * <p> 获取当前用户Session
     * @author: blackcat
     * @date: 2020/1/14 13:33
     * @return SysUserEntity 用户信息
    */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * <p> 用户登出
     * @author: blackcat
     * @date: 2020/1/14 13:34
     * @return void
    */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * <p> 获取当前用户信息
     * @author: blackcat
     * @date: 2020/1/14 13:34
     * @Param []
     * @return SysUserEntity 用户信息
    */
    public static SysUserEntity getUserInfo() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * <p> 删除用户缓存信息
     * @author: blackcat
     * @date: 2020/1/14 13:34
     * @Param [username:用户名称, isRemoveSession:是否删除Session]
     * @return void
    */
    public static void deleteCache(String username, boolean isRemoveSession){
        //从缓存中获取Session
        Session session = null;
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        SysUserEntity sysUserEntity;
        Object attribute = null;
        for(Session sessionInfo : sessions){
            //遍历Session,找到该用户名称对应的Session
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            sysUserEntity = (SysUserEntity) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (sysUserEntity == null) {
                continue;
            }
            if (Objects.equals(sysUserEntity.getUsername(), username)) {
                session=sessionInfo;
                break;
            }
        }
        if (session == null||attribute == null) {
            return;
        }
        //删除session
        if (isRemoveSession) {
            redisSessionDAO.delete(session);
        }
        //删除Cache，在访问受限接口时会重新授权
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authc = securityManager.getAuthenticator();
        ((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);
    }

}
