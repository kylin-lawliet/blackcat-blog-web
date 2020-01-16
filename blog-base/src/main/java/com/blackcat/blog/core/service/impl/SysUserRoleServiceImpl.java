package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.mapper.SysUserRoleMapper;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p> 用户与角色业务实现
 * @author: blackcat
 * @date: 2020/1/16 20:17
*/
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}