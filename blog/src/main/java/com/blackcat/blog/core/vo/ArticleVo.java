package com.blackcat.blog.core.vo;

import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogCode;
import lombok.Data;

import java.util.List;

/**
 * <p> 描述 ：博客相关信息
 * @author : blackcat
 * @date : 2020/3/3 15:37
 */
@Data
public class ArticleVo {
    // 博客文章
    private BlogArticle article;
    // 博客标签
    private List<BlogCode> tags;
}
