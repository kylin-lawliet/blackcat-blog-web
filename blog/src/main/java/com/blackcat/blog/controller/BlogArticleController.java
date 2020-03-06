package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogArticleTag;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogArticleTagService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 博客文章 前端控制器
 * @author blackcat
 * @date 2020-02-28
 */
@RestController
@RequestMapping("/article")
public class BlogArticleController {

    @Resource
    private BlogArticleService iBlogArticleService;
    @Resource
    private BlogArticleTagService iBlogArticleTagService;



    @RequestMapping("/getArticleByCondition/{id}")
    public ResultUtil getArticleByCondition(@PathVariable Long id) {
        QueryWrapper<BlogArticle> queryWrapper =new QueryWrapper<BlogArticle>();
//        queryWrapper.lambda().eq(BlogArticle::getPublish,1)
//        .and();
        List<BlogArticle> articles = iBlogArticleService.list();
        return ResultUtil.ok().put("data",articles);
    }

@   RequestMapping("/getCategory")
    public ResultUtil getCategory() {
        return ResultUtil.ok().put("data",iBlogArticleService.getCategory());
    }

    /**
    * <p> 描述 : 获取列表数据
    * @author : blackcat
    * @date  : 2020-02-28
    */
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        Page<BlogArticle> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<BlogArticle> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda().eq(BlogArticle::getContent,vo.getKeywords())
            .or().eq(BlogArticle::getTags,vo.getKeywords())
            .or().eq(BlogArticle::getTitle,vo.getKeywords())
            .or().eq(BlogArticle::getIntroduction,vo.getKeywords());
        }
        queryWrapper.lambda().orderByAsc(BlogArticle::getPublish).orderByDesc(BlogArticle::getUpdateTime);
        iBlogArticleService.page(page, queryWrapper);
        return ResultUtil.tablePage(page);
    }

    /**
    * <p> 描述 : 添加
    * @author : blackcat
    * @date  : 2020-02-28
    */
    @PostMapping(value = "/add")
    public ResultUtil add(BlogArticle entity) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser= (SysUser) subject.getPrincipal();
        entity.setUserId(sysUser.getId());
        if (StringUtils.isNotBlank(entity.getId().toString())) {
            iBlogArticleService.update(entity,null);
        } else {
            iBlogArticleService.save(entity);
        }

        if (StringUtils.isNotBlank(entity.getTags())) {
            editTags(entity.getTags(),entity.getId());
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

    /**
     * <p> 描述 : 编辑标签
     * @author : blackcat
     * @date  : 2020/3/3 13:14
    */
    private void editTags(String tagIds,Long articleId){
        String[] tagArr = tagIds.split(",");
        UpdateWrapper<BlogArticleTag> updateWrapper = new UpdateWrapper();
        updateWrapper.lambda().in(BlogArticleTag::getTagId,tagArr)
        .eq(BlogArticleTag::getArticleId,articleId);
        iBlogArticleTagService.remove(updateWrapper);

        if (tagArr.length > 0) {
            BlogArticleTag tag;
            List<BlogArticleTag> tags = new ArrayList<>();
            for (String str : tagArr) {
                if (StringUtils.isNotBlank(str)) {
                    tag = new BlogArticleTag();
                    tag.setTagId(Long.valueOf(str));
                    tag.setArticleId(articleId);
                    tags.add(tag);
                }
            }
            iBlogArticleTagService.saveBatch(tags);
        }
    }

    /**
    * <p> 描述 : 删除
    * @author : blackcat
    * @date  : 2020-02-28
    */
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iBlogArticleService.remove(new UpdateWrapper<BlogArticle>().in("id", ids));
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 编辑
    * @author : blackcat
    * @date  : 2020-02-28
    */
    @PostMapping("/edit")
    public ResultUtil edit(BlogArticle entity) {
        try {
            entity.setUpdateTime(LocalDateTime.now());
            iBlogArticleService.update(entity,null);
            if (StringUtils.isNotBlank(entity.getTags())) {
                editTags(entity.getTags(),entity.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
