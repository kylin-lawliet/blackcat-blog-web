package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogCodeList;

/**
 * <p> 分类码表总表 服务类
 * @author blackcat
 * @date 2020-02-27
 */
public interface BlogCodeListService extends IService<BlogCodeList> {

  /**
   * <p> : 批量删除
   * @author : blackcat
   * @date : 2020-02-27
   * @param ids 主键
   */
  void deleteBatchIds(Long[] ids);
}
