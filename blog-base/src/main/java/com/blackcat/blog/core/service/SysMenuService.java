package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.extend.MenuExtend;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:13
 * @Param
 * @return
*/
public interface SysMenuService extends IService<SysMenu> {
    
   /* *//**
     * <p> 根据角色查询用户权限
     * @author : blackcat
     * @date : 2020/1/16 20:12
     * @Param [roleId:角色ID]
     * @return List<MenuExtend> 权限集合
    *//*
    List<MenuExtend> selectSysMenuByRoleId(Long roleId);*/



    /**
     * <p> : 获取所有可用的菜单资源
     * @author : blackcat
     * @date : 2020/1/17 14:11
     * @return List<MenuExtend> 权限集合
    */
    List<MenuExtend> listAllAvailableMenu();

    /**
     * <p> : 获取用户的资源列表
     * @author : blackcat
     * @date : 2020/1/17 14:17
     * @Param [map]
     * @return List<MenuExtend> 权限集合
    */
    List<MenuExtend> listUserMenu(Map<String, Object> map);


}

