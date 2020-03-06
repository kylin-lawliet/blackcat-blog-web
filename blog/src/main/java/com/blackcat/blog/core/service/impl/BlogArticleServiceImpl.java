package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.mapper.BlogArticleMapper;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.vo.ArticleVo;
import com.blackcat.blog.core.vo.CategoryVo;
import com.blackcat.blog.util.MarkdownUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p> 博客文章 服务实现类
 * @author blackcat
 * @date 2020-02-28
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

    @Resource
    private BlogArticleMapper blogArticleMapper;
    @Resource
    private BlogCodeService iBlogCodeService;

    @Override
    public ArticleVo getArticleById(Long id,boolean comment,boolean markdown) {
        ArticleVo articleVo = new ArticleVo();
        BlogArticle blogArticle = blogArticleMapper.selectById(id);
        List<BlogCode> tags=iBlogCodeService.list(
                new QueryWrapper<BlogCode>().lambda()
                        .in(BlogCode::getId,blogArticle.getTags().split(",")));
        if(markdown){
            blogArticle.setContent(MarkdownUtils.renderMarkdown(blogArticle.getContent()));
        }
        if(comment){

        }
        articleVo.setArticle(blogArticle);
        articleVo.setTags(tags);
        return articleVo;
    }

    @Override
    public List<CategoryVo> getCategory() {
        return blogArticleMapper.getCategory();
    }
}
