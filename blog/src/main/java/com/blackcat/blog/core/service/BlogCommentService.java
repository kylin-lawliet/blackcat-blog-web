package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogComment;
import com.blackcat.blog.core.vo.CommentConditionVO;
import com.blackcat.blog.core.vo.CommentVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p> 博客评论表 服务类
 * @author blackcat
 * @date 2020-03-08
 */
public interface BlogCommentService extends IService<BlogComment> {

    /**
     * <p> 描述 : 查询所有评论
     * @author : blackcat
     * @date  : 2020/3/9 16:13
     */
    List<CommentVo> findAll(CommentConditionVO vo);

    /**
     * <p> 描述 : 分页查询
     * @author : blackcat
     * @date  : 2020/3/9 16:16
    */
    PageInfo<CommentVo> findPageBreakByCondition(CommentConditionVO vo);
}
