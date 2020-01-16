package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysRole;

import java.util.List;

/**
 * <p> 角色Mapper
 * @author: blackcat
 * @date: 2020/1/16 20:09
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * <p> 通过用户ID查询角色集合
     * @author: blackcat
     * @date: 2020/1/16 20:09
     * @Param [userId:用户ID]
     * @return List<SysRole> 角色名集合
    */
    List<SysRole> selectSysRoleByUserId(Long userId);
	
}
