package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysUser;

import java.util.List;

/**
 * <p> 系统用户表 Mapper 接口
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * <p> 描述 : 查询角色用户
     * @author : blackcat
     * @date  : 2020/2/10 12:59
    */
    List<SysUser> listByRoleId(Long roleId);
}
