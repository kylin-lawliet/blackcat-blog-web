package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.mapper.SysUserMapper;
import com.blackcat.blog.core.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * <p> 系统用户表 服务实现类
 * @author blackcat
 * @date 2020-01-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysUserMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public SysUser getByUserName(Map<String, String> map) {
        return null;
    }
}
