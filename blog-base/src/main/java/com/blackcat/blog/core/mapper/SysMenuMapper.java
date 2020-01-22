package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.vo.MenuConditionVO;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限Mapper
 * @author : blackcat
 * @serialData : 2020/1/16 20:08
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @serialData : 2020/1/19 13:27
     * @param [vo]
     * @return  List<SysMenu>
    */
    List<SysMenu> findPageBreakByCondition(MenuConditionVO vo);


    /**
     * <p> : 获取所有可用的菜单资源
     * @author : blackcat
     * @serialData : 2020/1/17 14:13
     * @return List<SysMenu> 权限集合
    */
    List<SysMenu> listAllAvailableMenu();

    /**
     * <p> : 获取用户的资源列表
     * @author : blackcat
     * @serialData : 2020/1/17 14:33
     * @param [map]
     * @return java.util.List<com.blackcat.blog.core.entity.SysMenu>
    */
    List<SysMenu> listUserMenu(Map<String, Object> map);




    /**
     * <p> 根据角色查询用户权限
     * @author : blackcat
     * @serialData : 2020/1/16 20:08
     * @param [roleId:角色ID]
     * @return List<SysMenu> 权限集合
    */
    //List<SysMenu> selectSysMenuByRoleId(Long roleId);


	
}
