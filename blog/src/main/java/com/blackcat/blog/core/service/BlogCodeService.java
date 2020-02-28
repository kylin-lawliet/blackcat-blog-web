package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogCode;

import java.util.List;

/**
 * <p> 博客分类码表 服务类
 * @author blackcat
 * @date 2020-02-26
 */
public interface BlogCodeService extends IService<BlogCode> {

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-02-26
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);

  /**
   * <p> 描述 : 码表父级资源选择
   * @author : blackcat
   * @date  : 2020/2/27 16:04
  */
  List<BlogCode> getParents(Long id);
}
