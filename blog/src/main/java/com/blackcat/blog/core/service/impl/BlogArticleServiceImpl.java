package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.mapper.BlogArticleMapper;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.vo.ArticleVo;
import com.blackcat.blog.core.vo.CategoryVo;
import com.blackcat.blog.core.vo.CommentCountVo;
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
    public void updateArticleViewCount(Long id) {
        UpdateWrapper<BlogArticle> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(BlogArticle::getId, id);
        updateWrapper.setSql("view_count = view_count+1");
        blogArticleMapper.update(null,updateWrapper);
    }

    @Override
    public List<BlogArticle> getTop() {
        QueryWrapper<BlogArticle> queryWrapper = new QueryWrapper();
        queryWrapper.lambda()
        .orderByDesc(
                BlogArticle::getViewCount,
                BlogArticle::getStarCount,
                BlogArticle::getCommentCount,
                BlogArticle::getCreateTime).last("limit 5");
        return blogArticleMapper.selectList(queryWrapper);
    }

    @Override
    public void updateArticleCommentCount(Long id) {
//        BlogArticle blogArticle = blogArticleMapper.selectById(id);
//        blogArticle.setCommentCount(blogArticle.getCommentCount().add(BigDecimal.ONE));
//        blogArticleMapper.updateById(blogArticle);
        UpdateWrapper<BlogArticle> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(BlogArticle::getId, id);
        updateWrapper.setSql("comment_count = comment_count+1");
        blogArticleMapper.update(null,updateWrapper);
    }

    /**
     * <p> 描述 : 修改文章评论格式 减去
     * @author : blackcat
     * @date  : 2020/3/11 15:00
     * @param id
     * @param count
     * @return void
    */
    private void updateArticleCommentCount(Long id,Integer count){
//        BlogArticle blogArticle = blogArticleMapper.selectById(id);
//        blogArticle.setCommentCount(blogArticle.getCommentCount().subtract(new BigDecimal(count)));
//        blogArticleMapper.updateById(blogArticle);
        UpdateWrapper<BlogArticle> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(BlogArticle::getId, id);
        updateWrapper.setSql("commentCount = commentCount-"+count+"");
        blogArticleMapper.update(null,updateWrapper);
    }

    @Override
    public void updateArticleCommentCount(Long[] ids) {
        List<CommentCountVo> getCommentCount = blogArticleMapper.getCommentCount(ids);
        if(getCommentCount!=null){
            getCommentCount.forEach(obj->{
                updateArticleCommentCount(obj.getArticleId(),obj.getCommentCount());
            });
        }
    }

    @Override
    public ArticleVo getArticleById(Long id,boolean markdown) {
        ArticleVo articleVo = new ArticleVo();
        BlogArticle blogArticle = blogArticleMapper.selectById(id);
        List<BlogCode> tags=iBlogCodeService.list(
                new QueryWrapper<BlogCode>().lambda()
                        .in(BlogCode::getId,blogArticle.getTags().split(",")));
        if(markdown){
            blogArticle.setContent(MarkdownUtils.renderMarkdown(blogArticle.getContent()));
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
