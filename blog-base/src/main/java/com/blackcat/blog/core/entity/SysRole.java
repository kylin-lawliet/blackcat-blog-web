package com.blackcat.blog.core.entity;

import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * <p> 角色
 * @author: blackcat
 * @date: 2020/1/16 15:06
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends AbstractDO {
	private String name;// 角色名
	private String description;// 描述
	private Boolean available;// 是否可用

	@Transient
	private Integer selected;
}
