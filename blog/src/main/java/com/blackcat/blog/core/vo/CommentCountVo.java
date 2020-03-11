package com.blackcat.blog.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 描述 ：
 *
 * @author : blackcat
 * @date : 2020/3/11 19:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCountVo {
    private Long articleId;
    private Integer commentCount;
}
