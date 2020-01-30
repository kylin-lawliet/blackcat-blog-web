package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.vo.BaseConditionVO;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限表 Mapper 接口
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020-01-29
     * @param vo 条件封装
     * @return  List<SysMenu>
     */
    List<SysMenu> findPageBreakByCondition(BaseConditionVO vo);

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
     * @param map 参数
     * @return List<SysMenu> 权限集合
     */
    List<SysMenu> listUserMenu(Map<String, Object> map);

}
