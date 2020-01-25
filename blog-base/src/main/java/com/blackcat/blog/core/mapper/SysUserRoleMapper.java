package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysUserRole;

import java.util.List;

/**
 * <p> 用户与角色Mapper
 * @author : blackcat
 * @date : 2020/1/16 20:10
*/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    List<Integer> findUserIdByRoleId(Integer roleId);
}
