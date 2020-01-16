package com.blackcat.blog.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.mapper.SysMenuMapper;
import com.blackcat.blog.core.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 权限业务实现
 * @author: blackcat
 * @date: 2020/1/16 20:15
*/
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    /**
     * <p> 根据角色查询用户权限
     * @author: blackcat
     * @date: 2020/1/16 20:15
     * @Param [roleId:角色ID]
     * @return List<SysMenu> 权限集合
    */
    @Override
    public List<SysMenu> selectSysMenuByRoleId(Long roleId) {
        return this.baseMapper.selectSysMenuByRoleId(roleId);
    }
}