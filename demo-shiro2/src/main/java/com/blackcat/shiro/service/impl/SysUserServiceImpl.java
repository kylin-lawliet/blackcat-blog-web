package com.blackcat.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.shiro.entity.SysUser;
import com.blackcat.shiro.mapper.SysUserMapper;
import com.blackcat.shiro.service.SysUserService;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * <p> 系统用户表 服务实现类
 * @author blackcat
 * @date 2020-02-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> findPageBreakByCondition(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysUser> list = sysUserMapper.findPageBreakByCondition(vo);
        PageInfo bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysUserMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
