package com.blackcat.blog.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p> 描述 ：评论
 * @author : blackcat
 * @date : 2020/3/9 14:07
 */
@Data
public class CommentVo implements Comparable<CommentVo>{
    /**
     * 评论id
     */
    private Long id;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 评论用户id
     */
    private Integer userId;

    /**
     * 评论文章id
     */
    private Long articleId;
    /**
     * 评论用户
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 评论文章标题
     */
    private String articleTitle;
    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private LocalDateTime createTime;

    /**
     * 回复评论id
     */
    private Long parentId;

    private CommentVo parent;
    private List<CommentVo> nodes;

    @Override
    public int compareTo(CommentVo o) {
        return o.getCreateTime().compareTo(this.getCreateTime());
    }
}
