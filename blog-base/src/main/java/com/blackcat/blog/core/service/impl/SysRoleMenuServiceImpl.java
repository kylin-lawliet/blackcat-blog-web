package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.mapper.SysRoleMenuMapper;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p> 角色与权限业务实现
 * @author: blackcat
 * @date: 2020/1/16 20:16
*/
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

}