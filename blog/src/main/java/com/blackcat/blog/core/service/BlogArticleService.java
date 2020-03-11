package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.vo.ArticleVo;
import com.blackcat.blog.core.vo.CategoryVo;

import java.util.List;

/**
 * <p> 博客文章 服务类
 * @author blackcat
 * @date 2020-02-28
 */
public interface BlogArticleService extends IService<BlogArticle> {


    /**
     * <p> 描述 : 获取热门文章 前五篇
     * @author : blackcat
     * @date  : 2020/3/11 13:11
    */
    List<BlogArticle> getTop();

    /**
     * <p> 描述 : 修改文章评论条数 添加
     * @author : blackcat
     * @date  : 2020/3/11 13:19
     * @param id 文章id
     * @return void
    */
    void updateArticleCommentCount(Long id);

    /**
     * <p> 描述 : 修改文章评论条数 删除
     * @author : blackcat
     * @date  : 2020/3/11 13:32
     * @param ids
     * @return void
    */
    void updateArticleCommentCount(Long[] ids);

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

    /**
     * <p> 描述 : 查询首页分类结果集
     * @author : blackcat
     * @date  : 2020/3/6 12:33
     */
    List<CategoryVo> getCategory();
}
