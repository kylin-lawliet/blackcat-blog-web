package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 角色与权限
 * @author : blackcat
 * @serialData : 2020/1/16 15:07
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
public class SysRoleMenu extends AbstractDO {
	private Long roleId;// 角色ID
	private Long menuId;// 权限ID
}
