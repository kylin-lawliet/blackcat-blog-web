package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * <p> 角色表 服务类
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysRoleService extends IService<SysRole> {

  /**
   * <p> 描述 : 查询用户角色
   * @author : blackcat
   * @date  : 2020/2/1 13:41
  */
  List<SysRole> listRolesByUserId(Integer userId);

  /**
   * <p> 描述 : 获取ztree使用的角色列表
   * @author : blackcat
   * @param uid 用户id
   * @date  : 2020/1/30 21:15
   */
  List<Map<String, Object>> queryRoleListWithSelected(Integer uid);


  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-01-29
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
