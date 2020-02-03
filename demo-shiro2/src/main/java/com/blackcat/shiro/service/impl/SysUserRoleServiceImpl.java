package com.blackcat.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.shiro.entity.SysUserRole;
import com.blackcat.shiro.mapper.SysUserRoleMapper;
import com.blackcat.shiro.service.SysUserRoleService;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * <p> 用户与角色关系表 服务实现类
 * @author blackcat
 * @date 2020-02-03
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public PageInfo<SysUserRole> findPageBreakByCondition(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysUserRole> list = sysUserRoleMapper.findPageBreakByCondition(vo);
        PageInfo bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysUserRoleMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
