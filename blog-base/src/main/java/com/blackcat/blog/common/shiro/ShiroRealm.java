package com.blackcat.blog.common.shiro;

import com.blackcat.blog.core.entity.*;
import com.blackcat.blog.core.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * <p> ： Shiro权限匹配和账号密码匹配
 * @author: blackcat
 * @date: 2020/1/13 17:38
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * <p>  授权权限
     * <p> 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @author: blackcat
     * @date: 2020/1/14 19:40
     * @Param [principalCollection]
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SysUserEntity sysUserEntity = (SysUserEntity) principalCollection.getPrimaryPrincipal();
        //获取用户ID
        Long userId =sysUserEntity.getUserId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();
        Set<String> permsSet = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.selectSysRoleByUserId(userId);
        for (SysRoleEntity sysRoleEntity:sysRoleEntityList) {
            rolesSet.add(sysRoleEntity.getRoleName());
            List<SysMenuEntity> sysMenuEntityList = sysMenuService.selectSysMenuByRoleId(sysRoleEntity.getRoleId());
            for (SysMenuEntity sysMenuEntity :sysMenuEntityList) {
                permsSet.add(sysMenuEntity.getPerms());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        info.setStringPermissions(permsSet);
        info.setRoles(rolesSet);
        return info;
    }

    /**
     * <p> 身份认证
     * <p> 获取即将需要认证的信息
     * @author: blackcat
     * @date: 2020/1/14 19:41
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUserEntity user = sysUserService.selectUserByName(userName);
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(userName, user.getPassword(),
                ByteSource.Util.bytes(userName + "salt"), getName());
    }
}
