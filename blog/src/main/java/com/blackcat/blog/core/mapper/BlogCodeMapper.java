package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.BlogCode;

import java.util.List;

/**
 * <p> 博客分类码表 Mapper 接口
 * @author blackcat
 * @date 2020-02-26
 */
public interface BlogCodeMapper extends BaseMapper<BlogCode> {

    /**
     * <p> 描述 : 获取码表详细
     * @author : blackcat
     * @date  : 2020/3/3 17:19
     * @param codeId  BlogCodeList主键
     * @return java.util.List<com.blackcat.blog.core.entity.BlogCode>
    */
    List<BlogCode> listCodeByType(String codeId);
}
