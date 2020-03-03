package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 博客文章
 * </p>
 *
 * @author blackcat
 * @since 2020-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogArticle extends Model<BlogArticle> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 分类编号(0:未分类)
     */
    private Long categoryId;

    /**
     * 博客点赞
     */
    private BigDecimal starCount;

    /**
     * 浏览总量
     */
    private BigDecimal viewCount;

    /**
     * 是否置顶 0:否 1:是
     */
    private BigDecimal top;

    /**
     * 是否发布 0:否 1:是
     */
    private BigDecimal publish;

    /**
     * 相关标签，逗号分隔
     */
    private String tags;

    /**
     * 博客简介
     */
    private String introduction;

    /**
     * 评论数量（无论是评论还是回复都需要对此字段+1）
     */
    private BigDecimal commentCount;

    /**
     * 博客内容类型[markdown tinymce）]
     */
    private String contentType;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
