package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysMenu;

import java.util.List;

/**
 * <p> 权限业务接口
 * @author: blackcat
 * @date: 2020/1/16 20:13
 * @Param
 * @return
*/
public interface SysMenuService extends IService<SysMenu> {
    
    /**
     * <p> 根据角色查询用户权限
     * @author: blackcat
     * @date: 2020/1/16 20:12
     * @Param [roleId:角色ID]
     * @return List<SysMenu> 权限集合
    */
    List<SysMenu> selectSysMenuByRoleId(Long roleId);

}

