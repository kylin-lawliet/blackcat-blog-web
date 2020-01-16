package com.blackcat.blog.core.entity;

import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 用户与角色
 * @author: blackcat
 * @date: 2020/1/16 15:09
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRole extends AbstractDO {
	private Long userId;// 用户ID
	private Long roleId;// 角色ID
}
