package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.vo.ArticleVo;

/**
 * <p> 博客文章 服务类
 * @author blackcat
 * @date 2020-02-28
 */
public interface BlogArticleService extends IService<BlogArticle> {

    /**
     * <p> 描述 : 查询博客相关信息
     * @author : blackcat
     * @date  : 2020/3/3 15:42
     * @param id 主键
     * @param comment 是否查询评论信息
     * @param markdown 是否渲染markdown
     * @return com.blackcat.blog.core.vo.ArticleVo
    */
    ArticleVo getArticleById(Long id,boolean comment,boolean markdown);
}
