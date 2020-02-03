package com.blackcat.shiro.service;

import com.blackcat.shiro.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * <p> 角色与权限关系表 服务类
 * @author blackcat
 * @date 2020-02-03
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

  /**
   * <p> : 分页查询
   * @author : blackcat
   * @date : 2020-02-03
   * @param vo 条件封装
   * @return  List<SysMenu>
   */
  PageInfo<SysRoleMenu> findPageBreakByCondition(BaseConditionVO vo);

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-02-03
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
