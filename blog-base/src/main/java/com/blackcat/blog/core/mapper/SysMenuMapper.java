package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysMenu;

import java.util.List;

/**
 * <p> 权限Mapper
 * @author: blackcat
 * @date: 2020/1/16 20:08
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * <p> 根据角色查询用户权限
     * @author: blackcat
     * @date: 2020/1/16 20:08
     * @Param [roleId:角色ID]
     * @return List<SysMenu> 权限集合
    */
    List<SysMenu> selectSysMenuByRoleId(Long roleId);
	
}
