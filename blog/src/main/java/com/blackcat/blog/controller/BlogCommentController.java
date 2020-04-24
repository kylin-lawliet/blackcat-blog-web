package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.blog.core.entity.BlogComment;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogCommentService;
import com.blackcat.blog.core.service.BlogMessageService;
import com.blackcat.blog.core.vo.CommentConditionVO;
import com.blackcat.blog.core.vo.CommentVo;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p> 博客评论表 前端控制器
 * @author blackcat
 * @date 2020-03-08
 */
@RestController
@RequestMapping("/comment")
public class BlogCommentController {

    @Resource
    private BlogCommentService iBlogCommentService;
    @Resource
    private BlogArticleService iBlogArticleService;
    @Resource
    private BlogMessageService iBlogMessageService;

    /**
     * <p> 描述 : 获取文章评论
     * @author : blackcat
     * @date  : 2020/3/9 16:41
    */
    @GetMapping("/getAllByArticleId/{id}")
    public ResultUtil getAllByArticleId(@PathVariable Long id){
        CommentConditionVO vo = new CommentConditionVO();
        vo.setArticleId(String.valueOf(id));
        return ResultUtil.ok().put("data",iBlogCommentService.findAll(vo));
    }

    /**
    * <p> 描述 : 获取列表数据
    * @author : blackcat
    * @date  : 2020-03-08
    */
    @RequiresPermissions("comments")
    @RequestMapping("/list")
    public PageResult list(CommentConditionVO vo){
        PageInfo<CommentVo> pageInfo = iBlogCommentService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
    * <p> 描述 : 添加
    * @author : blackcat
    * @date  : 2020-03-08
    */
    @PostMapping(value = "/add")
    public ResultUtil add(BlogComment entity) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser= (SysUser) subject.getPrincipal();
        entity.setUserId(sysUser.getId());
        iBlogCommentService.save(entity);
        iBlogArticleService.updateArticleCommentCount(entity.getArticleId());
        if(entity.getParentId()!=null){
            Integer toUserId=iBlogCommentService.getById(entity.getParentId()).getUserId();
            iBlogMessageService.add(sysUser.getId(),toUserId,entity.getArticleId(),1);
        }else {
            iBlogMessageService.add(sysUser.getId(),null,entity.getArticleId(),1);
        }
        return ResultUtil.ok().put("data",entity);
    }

    /**
    * <p> 描述 : 删除
    * @author : blackcat
    * @date  : 2020-03-08
    */
    @RequiresPermissions(value = {"comment:batchDelete", "comment:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iBlogCommentService.remove(new UpdateWrapper<BlogComment>().in("id", ids));
        iBlogArticleService.updateArticleCommentCount(ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 获取详情
    * @author : blackcat
    * @date  : 2020-03-08
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        return ResultUtil.ok().put("data",iBlogCommentService.getById(id));
    }

    /**
    * <p> 描述 : 编辑
    * @author : blackcat
    * @date  : 2020-03-08
    */
    @PostMapping("/edit")
    public ResultUtil edit(BlogComment entity) {
        try {
            iBlogCommentService.updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
    }
}
