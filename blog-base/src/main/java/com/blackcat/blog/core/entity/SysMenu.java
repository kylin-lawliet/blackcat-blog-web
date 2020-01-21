package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * <p> 权限菜单
 * @author : blackcat
 * @date : 2020/1/16 15:05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenu extends AbstractDO {

	private String name;// 权限名称
	private String type;// 权限类型（菜单，按钮）
	private String url;// 资源路径
	private String permission;// 权限标识
	private Long parentId;// 父节点
	private Integer sort;// 排序
	private Boolean external;// 是否外部链接
	private Boolean available;// 是否可用
	private String icon;// 菜单图标

	@Transient
	@TableField(exist = false)
	private String checked;
	@Transient
	@TableField(exist = false)
	private SysMenu parent;
	@Transient
	@TableField(exist = false)
	private List<SysMenu> nodes;

}
