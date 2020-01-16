package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysUser;

/**
 * <p> 用户业务接口
 * @author: blackcat
 * @date: 2020/1/16 20:15
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * <p> 根据用户名查询实体
     * @author: blackcat
     * @date: 2020/1/16 20:14
     * @Param [username:用户名]
     * @return 用户实体
    */
    SysUser selectUserByName(String username);

}

