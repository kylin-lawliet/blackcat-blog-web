package com.blackcat.blog.core.vo;

import com.blackcat.blog.core.extend.UserExtend;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> : 用户查询条件
 * @author : blackcat
 * @serialData : 2020/1/18 14:55
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class UserConditionVO extends BaseConditionVO {
    private UserExtend user;
}
