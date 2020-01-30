package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.mapper.SysRoleMenuMapper;
import com.blackcat.blog.core.service.SysRoleMenuService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * <p> 角色与权限关系表 服务实现类
 * @author blackcat
 * @date 2020-01-29
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
