package com.blackcat.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.blackcat.blog.core.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p> 用户
 * @author : blackcat
 * @serialData : 2020/1/16 15:08
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUser extends AbstractDO {
	private String username;// 用户名称
	private String password;// 登录密码
	private String nickname;// 昵称
	private String mobile;// 手机号
	private String email;// 邮箱地址
	private Date birthday;// 生日
	private Integer gender;// 性别
	private String avatar;// 头像地址
	private String userType;// 用户类型 超级管理员、管理员、普通用户
	private String regIp;// 注册IP
	private String lastLoginIp;// 最近登录IP
	private Date lastLoginTime;// 最近登录时间
	private Integer loginCount;// 登录次数
	private String remark;// 备注
	private Integer status;// 状态

}
