package com.blackcat.blog.core.entity;

import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 角色与权限
 * @author: blackcat
 * @date: 2020/1/16 15:07
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleMenu extends AbstractDO {
	private Long roleId;// 角色ID
	private Long menuId;// 权限ID
}
