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
   * <p> 描述 : 码表分类选择（遗弃 存留以参考代码）
   * @author : blackcat
   * @date  : 2020/2/27 16:04
  */
  List<BlogCode> getParents(String id);

  /**
   * <p> 描述 : 码表数据
   * - - - 递归获取所有子节点
   * @author : blackcat
   * @date  : 2020/3/4 15:52
   * @param id BlogCodeList 主键
   * @return 包含所有子节点数据树
  */
  List<BlogCode> getCodesByCodeListId(String id);
}
