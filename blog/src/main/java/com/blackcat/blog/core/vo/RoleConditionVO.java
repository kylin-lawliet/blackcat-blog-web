package com.blackcat.blog.core.vo;

import com.blackcat.blog.core.extend.RoleExtend;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleConditionVO extends BaseConditionVO {
    private RoleExtend role;
}

