package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 用户与角色
 * @author : blackcat
 * @serialData : 2020/1/16 15:09
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole extends AbstractDO {
	private Long userId;// 用户ID
	private Long roleId;// 角色ID
}
