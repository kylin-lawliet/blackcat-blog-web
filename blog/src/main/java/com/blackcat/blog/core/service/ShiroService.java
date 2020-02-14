package com.blackcat.blog.core.service;

import com.blackcat.blog.core.entity.SysUser;

import java.util.Map;


/**
 * <p> 描述 : Shiro-权限相关的业务处理
 * @author : blackcat
 * @date  : 2020/2/8 16:25
*/
public interface ShiroService {

    /**
     * <p> 描述 : 初始化权限
     * @author : blackcat
     * @date  : 2020/2/8 16:26
    */
    Map<String, String> loadFilterChainDefinitions();

    /**
     * <p> 描述 : 重新加载权限
     * @author : blackcat
     * @date  : 2020/2/8 16:26
    */
    void updatePermission();

    /**
     * <p> 描述 : 重新加载用户权限
     * @author : blackcat
     * @date  : 2020/2/8 16:26
    */
    void reloadAuthorizingByUserId(SysUser user);

    /**
     * <p> 描述 : 重新加载所有拥有roleId角色的用户的权限
     * @author : blackcat
     * @date  : 2020/2/8 16:26
    */
    void reloadAuthorizingByRoleId(Long roleId);

}
