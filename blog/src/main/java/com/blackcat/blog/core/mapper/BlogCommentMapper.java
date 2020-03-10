package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.BlogComment;
import com.blackcat.blog.core.vo.CommentConditionVO;
import com.blackcat.blog.core.vo.CommentVo;

import java.util.List;

/**
 * <p> 博客评论表 Mapper 接口
 * @author blackcat
 * @date 2020-03-08
 */
public interface BlogCommentMapper extends BaseMapper<BlogComment> {

    /**
     * <p> 描述 : 查询所有评论
     * @author : blackcat
     * @date  : 2020/3/9 16:13
    */
    List<CommentVo> findAll(CommentConditionVO vo);
}
