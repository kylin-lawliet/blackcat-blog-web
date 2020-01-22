package com.blackcat.blog.core.service;

import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.common.base.AbstractService;
import com.blackcat.blog.core.object.AbstractIService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限业务接口
 * @author : blackcat
 * @serialData : 2020/1/16 20:13
 * @param
 * @return
*/
public interface SysMenuService extends AbstractIService<MenuExtend, Long> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @serialData : 2020/1/19 13:32
     * @param [vo]
     * @return List<MenuExtend> 权限集合
    */
    PageInfo<MenuExtend> findPageBreakByCondition(MenuConditionVO vo);

    
   /* *//**
     * <p> 根据角色查询用户权限
     * @author : blackcat
     * @serialData : 2020/1/16 20:12
     * @param [roleId:角色ID]
     * @return List<MenuExtend> 权限集合
    *//*
    List<MenuExtend> selectSysMenuByRoleId(Long roleId);*/



    /**
     * <p> : 获取所有可用的菜单资源
     * @author : blackcat
     * @serialData : 2020/1/17 14:11
     * @return List<MenuExtend> 权限集合
    */
    List<MenuExtend> listAllAvailableMenu();

    /**
     * <p> : 获取用户的资源列表
     * @author : blackcat
     * @serialData : 2020/1/17 14:17
     * @param [map]
     * @return List<MenuExtend> 权限集合
    */
    List<MenuExtend> listUserMenu(Map<String, Object> map);


}

