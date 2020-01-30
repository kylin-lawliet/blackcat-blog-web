package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.mapper.SysUserMapper;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;


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
}
