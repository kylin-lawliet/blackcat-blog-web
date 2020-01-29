package com.blackcat.mybatis.service.impl;

import com.blackcat.mybatis.entity.SysUser;
import com.blackcat.mybatis.mapper.SysUserMapper;
import com.blackcat.mybatis.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author blackcat
 * @since 2020-01-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
