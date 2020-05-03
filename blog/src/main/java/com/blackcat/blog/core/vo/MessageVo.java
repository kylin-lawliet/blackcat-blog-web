package com.blackcat.blog.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p> 描述 ：通知消息
 * @author : blackcat
 * @date : 2020/4/27 17:44
 */
@Data
public class MessageVo {

    private Long id;
    private Integer event;
    private String message;
    private String userName;
    private String toUserName;
    private String articleTitle;
    private Long articleId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private LocalDateTime createTime;
    private String status;

}
