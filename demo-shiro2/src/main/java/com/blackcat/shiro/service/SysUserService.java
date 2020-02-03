package com.blackcat.shiro.service;

import com.blackcat.shiro.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * <p> 系统用户表 服务类
 * @author blackcat
 * @date 2020-02-03
 */
public interface SysUserService extends IService<SysUser> {

  /**
   * <p> : 分页查询
   * @author : blackcat
   * @date : 2020-02-03
   * @param vo 条件封装
   * @return  List<SysMenu>
   */
  PageInfo<SysUser> findPageBreakByCondition(BaseConditionVO vo);

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-02-03
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
