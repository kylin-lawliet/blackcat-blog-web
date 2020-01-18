package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.mapper.SysUserMapper;
import com.blackcat.blog.core.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * <p> 系统用户业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:17
*/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * <p> 根据用户名查询实体
     * @author : blackcat
     * @date : 2020/1/16 20:17
     * @Param [username:用户名]
     * @return 用户实体
    */
    @Override
    public SysUser selectUserByName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }
}