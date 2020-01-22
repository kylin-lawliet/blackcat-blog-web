package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.mapper.SysRoleMapper;
import com.blackcat.blog.core.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 角色业务实现
 * @author : blackcat
 * @serialData : 2020/1/16 20:17
*/
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * <p> 通过用户ID查询角色集合
     * @author : blackcat
     * @serialData : 2020/1/16 20:16
     * @param [userId:用户ID]
     * @return List<SysRole> 角色名集合
    */
    @Override
    public List<SysRole> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }
}