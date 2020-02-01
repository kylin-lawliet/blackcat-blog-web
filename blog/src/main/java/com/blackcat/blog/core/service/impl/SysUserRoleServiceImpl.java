package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.mapper.SysUserRoleMapper;
import com.blackcat.blog.core.service.SysUserRoleService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * <p> 用户与角色关系表 服务实现类
 * @author blackcat
 * @date 2020-01-29
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageInfo<SysUserRole> findPageBreakByCondition(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysUserRole> list = sysUserRoleMapper.findPageBreakByCondition(vo);
        PageInfo<SysUserRole> bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysUserRoleMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
