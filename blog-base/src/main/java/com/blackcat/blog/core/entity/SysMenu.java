package com.blackcat.blog.core.entity;

import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * <p> 权限菜单
 * @author: blackcat
 * @date: 2020/1/16 15:05
 * @Param
 * @return
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenu extends AbstractDO {

	private String name;// 权限名称
	private String type;// 权限类型（菜单，按钮）
	private String url;// 菜单连接
	private String permission;// 权限标识
	private Long parentId;// 父节点
	private Integer sort;// 排序
	private Boolean external;// 是否外部链接
	private Boolean available;// 是否可用
	private String icon;// 菜单图标

	@Transient
	private String checked;
	@Transient
	private SysMenu parent;
	@Transient
	private List<SysMenu> nodes;

}
