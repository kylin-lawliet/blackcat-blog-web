package com.blackcat.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.shiro.entity.SysRoleMenu;
import com.blackcat.shiro.mapper.SysRoleMenuMapper;
import com.blackcat.shiro.service.SysRoleMenuService;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * <p> 角色与权限关系表 服务实现类
 * @author blackcat
 * @date 2020-02-03
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public PageInfo<SysRoleMenu> findPageBreakByCondition(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysRoleMenu> list = sysRoleMenuMapper.findPageBreakByCondition(vo);
        PageInfo bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysRoleMenuMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
