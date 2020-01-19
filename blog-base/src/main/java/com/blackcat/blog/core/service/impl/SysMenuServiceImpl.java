package com.blackcat.blog.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.mapper.SysMenuMapper;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p> 权限业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:15
*/
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired(required = false)
    private SysMenuMapper sysMenuMapper;

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020/1/19 13:35
    */
    @Override
    public PageInfo<MenuExtend> findPageBreakByCondition(MenuConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysMenu> sysMenus = sysMenuMapper.findPageBreakByCondition(vo);
        List<MenuExtend> menus = getResources(sysMenus);
        PageInfo bean = new PageInfo<>(sysMenus);
        bean.setList(menus);
        return bean;
    }

    /**
     * <p> 根据角色查询用户权限
     * @author : blackcat
     * @date : 2020/1/16 20:15
     * @Param [roleId:角色ID]
     * @return List<MenuExtend> 权限集合
    */
   /* @Override
    public List<MenuExtend> selectSysMenuByRoleId(Long roleId) {
        return this.baseMapper.selectSysMenuByRoleId(roleId);
    }
*/
    /**
     * <p> : 获取所有可用的菜单资源
     * @author : blackcat
     * @date : 2020/1/17 14:26
     * @return List<MenuExtend> 权限集合
    */
    @Override
    public List<MenuExtend> listAllAvailableMenu() {
        List<SysMenu> sysMenus = sysMenuMapper.listAllAvailableMenu();
        return getResources(sysMenus);
    }

    /**
     * <p> : 将系统权限类转为扩展类
     * @author : blackcat
     * @date : 2020/1/17 14:27
     * @Param List<SysMenu>
     * @return List<MenuExtend> 集合
    */
    private List<MenuExtend> getResources(List<SysMenu> sysMenus) {
        if (CollectionUtils.isEmpty(sysMenus)) {
            return null;
        }
        List<MenuExtend> resources = new ArrayList<>();
        for (SysMenu menu : sysMenus) {
            resources.add(new MenuExtend(menu));
        }
        return resources;
    }

    /**
     * <p> : 获取用户的资源列表
     * @author : blackcat
     * @date : 2020/1/17 14:35
     * @Param [map]
     * @return List<MenuExtend> 集合
    */
    @Override
    public List<MenuExtend> listUserMenu(Map<String, Object> map) {
        List<SysMenu> sysMenus = sysMenuMapper.listUserMenu(map);
        return getResources(sysMenus);
    }
}