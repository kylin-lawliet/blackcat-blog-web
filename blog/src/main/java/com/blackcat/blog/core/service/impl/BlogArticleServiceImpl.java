package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.mapper.BlogArticleMapper;
import com.blackcat.blog.core.service.BlogArticleService;
import org.springframework.stereotype.Service;


/**
 * <p> 博客文章 服务实现类
 * @author blackcat
 * @date 2020-02-28
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

}
