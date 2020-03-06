package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 博客分类码表
 * </p>
 *
 * @author blackcat
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogCode extends Model<BlogCode> implements Comparable<BlogCode>{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 码表总表id
     */
    private Long codeId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remarks;

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


    @Transient
    @TableField(exist = false)
    private BlogCode parent;
    @Transient
    @TableField(exist = false)
    private List<BlogCode> nodes;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public int compareTo(BlogCode o) {
        if (!this.getSort().equals(o.getSort())) {
            return this.getSort()-o.getSort();
        }
        return 0;
    }
}
