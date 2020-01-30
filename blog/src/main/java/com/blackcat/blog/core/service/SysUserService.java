package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysUser;

/**
 * <p> 系统用户表 服务类
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysUserService extends IService<SysUser> {

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-01-29
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
