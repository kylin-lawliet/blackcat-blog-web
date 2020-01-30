package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysRole;

import java.util.List;

/**
 * <p> 角色表 Mapper 接口
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * <p> 描述 : 获取ztree使用的角色列表
     * @author : blackcat
     * @param userId 用户id
     * @date  : 2020/1/30 21:15
    */
    List<SysRole> queryRoleListWithSelected(Integer userId);
}
