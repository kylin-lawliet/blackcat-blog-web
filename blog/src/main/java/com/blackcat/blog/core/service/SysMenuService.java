package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p> 权限表 服务类
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysMenuService extends IService<SysMenu> {

  /**
   * <p> 描述 : 获取用户关联的所有资源
   * @author : blackcat
   * @date  : 2020/2/1 13:51
   */
  List<SysMenu> listByUserId(Integer userId);

  /**
   * <p> 描述 : 查询角色资源
   * @author : blackcat
   * @date  : 2020/1/31 10:32
   * @param rid 角色id
   */
  List<Map<String, Object>> queryMenuListWithSelected(Long rid);

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

  /**
   * <p> : 分页查询
   * @author : blackcat
   * @date : 2020-01-29
   * @param vo 条件封装
   * @return  List<SysMenu>
   */
  PageInfo<SysMenu> findPageBreakByCondition(BaseConditionVO vo);

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-01-29
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
