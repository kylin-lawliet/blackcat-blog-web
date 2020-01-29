package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.extend.UserRoleExtend;
import com.blackcat.blog.core.object.AbstractIService;

/**
 * <p> 用户与角色业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:14
*/
public interface SysUserRoleService extends AbstractIService<UserRoleExtend,Long> {
    /**
     * 添加用户角色
     *
     * @param userId
     * @param roleIds
     */
    void addUserRole(Long userId, String roleIds);

    /**
     * 根据用户ID删除用户角色
     *
     * @param userId
     */
    void removeByUserId(Long userId);
}

