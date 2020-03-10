package com.blackcat.blog.core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> : SQL查询条件公共属性
 * @author : blackcat
 * @date : 2020/1/18 14:52
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class CommentConditionVO extends BaseConditionVO{
    private String articleId;
}
