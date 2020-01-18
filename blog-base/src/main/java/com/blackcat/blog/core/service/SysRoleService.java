package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysRole;

import java.util.List;

/**
 * <p> 角色业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:14
*/
public interface SysRoleService extends IService<SysRole> {

    /**
     * <p> 通过用户ID查询角色集合
     * @author : blackcat
     * @date : 2020/1/16 20:13
     * @Param [userId:用户ID]
     * @return List<SysRole> 角色名集合
    */
    List<SysRole> selectSysRoleByUserId(Long userId);
}

