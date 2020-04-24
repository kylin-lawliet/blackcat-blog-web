package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消息通知表
 * </p>
 *
 * @author blackcat
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogMessage extends Model<BlogMessage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 事件类型
     */
    private Integer event;

    /**
     * 消息内容内容
     */
    private String message;

    /**
     * 创建用户id
     */
    private Integer userId;

    /**
     * 发送用户id
     */
    private Integer toUserId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private LocalDateTime createTime;

    /**
     * 状态  0:未读 1:已读
     */
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
