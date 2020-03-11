package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.vo.CategoryVo;
import com.blackcat.blog.core.vo.CommentCountVo;

import java.util.List;

/**
 * <p> 博客文章 Mapper 接口
 * @author blackcat
 * @date 2020-02-28
 */
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

    List<CommentCountVo> getCommentCount(Long[] ids);

    /**
     * <p> 描述 : 查询首页分类结果集
     * @author : blackcat
     * @date  : 2020/3/6 12:33
    */
    List<CategoryVo> getCategory();
}
