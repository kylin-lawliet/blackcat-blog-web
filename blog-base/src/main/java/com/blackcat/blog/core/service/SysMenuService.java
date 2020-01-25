package com.blackcat.blog.core.service;

import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.object.AbstractIService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:13
*/
public interface SysMenuService extends AbstractIService<MenuExtend, Long> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020/1/19 13:32
     * @param vo 条件封装
     * @return List<MenuExtend> 权限集合
    */
    PageInfo<MenuExtend> findPageBreakByCondition(MenuConditionVO vo);

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
     * @param map 查询条件
     * @return List<MenuExtend> 权限集合
    */
    List<MenuExtend> listUserMenu(Map<String, Object> map);


}

