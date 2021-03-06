package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogArticleTag;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogArticleTagService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.core.vo.CategoryVo;
import com.blackcat.blog.util.RedisUtil;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.transaction.annotation.Transactional;
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
    @Resource
    private RedisUtil redisUtil;

@   RequestMapping("/getCategory")
    public ResultUtil getCategory() {
        List<CategoryVo> list;
        if(redisUtil.hasKey(RedisKey.MAIN_CATEGORY)){
            list = redisUtil.get(RedisKey.MAIN_CATEGORY,CategoryVo.class);
        }else{
            list = iBlogArticleService.getCategory();
            redisUtil.set(RedisKey.MAIN_CATEGORY,list);
        }
        return ResultUtil.ok().put("data",list);
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
    @Transactional
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
        redisUtil.set(RedisKey.ARTICLE+entity.getId(),entity);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

    /**
     * <p> 描述 : 编辑标签
     * @author : blackcat
     * @date  : 2020/3/3 13:14
    */
    private void editTags(String tagIds,Long articleId){
        String[] tagArr = StringUtils.split(tagIds, ',');
        UpdateWrapper<BlogArticleTag> updateWrapper = new UpdateWrapper();
        updateWrapper.lambda().in(BlogArticleTag::getTagId,tagArr)
        .eq(BlogArticleTag::getArticleId,articleId);
        iBlogArticleTagService.remove(updateWrapper);
        redisUtil.delete(RedisKey.ARTICLE_TAG,tagArr);

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
            tags.forEach(i-> redisUtil.set(RedisKey.ARTICLE_TAG+i.getId(),i));
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
        redisUtil.deleteSub(RedisKey.ARTICLE,ids);
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
            redisUtil.set(RedisKey.ARTICLE+entity.getId(),entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
