package com.blackcat.blog.core.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.common.CommonMethod;
import com.blackcat.blog.core.entity.*;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.mapper.*;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p> 权限业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:15
*/
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired(required = false)
    private SysMenuMapper sysMenuMapper;

    /**
     * <p> : 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @author : blackcat
     * @date : 2020/1/20 18:22
     * @Param [entity]
     * @return boolean
    */
    @Override
    public boolean insert(MenuExtend entity) {
        Assert.notNull(entity, "insert(entity)不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return CommonMethod.retBool(sysMenuMapper.insert(entity.getSysMenu()));
    }

    /**
     * <p> : 根据主键字段进行删除
     * @author : blackcat
     * @date : 2020/1/20 18:25
     * @Param [primaryKey]
     * @return boolean
    */
//    @Override
//    public boolean removeByPrimaryKey(Long primaryKey) {
////        sysMenuMapper.d
//        return CommonMethod.retBool(sysMenuMapper.deleteById(primaryKey));
//    }

    /**
     * <p> : 批量删除
     * @author : blackcat
     * @date : 2020/1/20 21:48
    */
    @Override
    public void deleteBatchIds(Long[] ids) {
        sysMenuMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * <p> : 根据主键更新属性不为null的值
     * @author : blackcat
     * @date : 2020/1/20 18:30
     * @Param [entity]
     * @return boolean
    */
    @Override
    public boolean updateById(MenuExtend entity) {
        Assert.notNull(entity, "updateById(entity)不可为空！");
        entity.setUpdateTime(new Date());
        return CommonMethod.retBool(sysMenuMapper.updateById(entity.getSysMenu()));
    }

    /**
     * <p> : 根据主键字段进行查询
     * @author : blackcat
     * @date : 2020/1/20 18:26
     * @Param [primaryKey]
    */
    @Override
    public MenuExtend getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysMenu sysMenu = sysMenuMapper.selectById(primaryKey);
        return null == sysMenu ? null : new MenuExtend(sysMenu);
    }

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