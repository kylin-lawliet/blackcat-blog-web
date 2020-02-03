package com.blackcat.blog.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.service.SysRoleService;
import com.blackcat.blog.core.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> ： Shiro权限匹配和账号密码匹配
 * @author : blackcat
 * @date : 2020/1/13 17:38
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysMenuService sysMenuService;

    /**
     * <p> 描述 : 授权权限
     * @author : blackcat
     * @date  : 2020/2/1 12:32
     * @return org.apache.shiro.authz.AuthorizationInfo
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用户信息
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        // 赋予角色
        List<SysRole> roleList = sysRoleService.listRolesByUserId(sysUser.getId());
        roleList.forEach(role -> info.addRole(role.getName()));
        // 赋予权限
        List<SysMenu> menusList = sysMenuService.listByUserId(sysUser.getId());
        menusList.forEach(menu -> {
            if (StringUtils.isNotBlank(menu.getPermission())) {
                info.addStringPermission(menu.getPermission());
            }
        });
        return info;
    }

    /**
     * <p> 描述 : 身份认证
     * @author : blackcat
     * @date  : 2020/2/1 12:32
     * @return org.apache.shiro.authc.AuthenticationInfo
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        // 可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUser user = sysUserService.getOne(new QueryWrapper<SysUser>().eq("username", username));
        if (user == null) {
            throw new UnknownAccountException("账号不存在！");
        }
        if (!userPwd.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus() != null && 0==user.getStatus()) {
            throw new LockedAccountException("帐号已被锁定，禁止登录！");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(), getName());
    }

}
