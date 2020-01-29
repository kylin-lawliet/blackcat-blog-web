package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.extend.RoleExtend;
import com.blackcat.blog.core.mapper.SysRoleMapper;
import com.blackcat.blog.core.service.SysRoleService;
import com.blackcat.blog.core.vo.RoleConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p> 角色业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:17
*/
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired(required = false)
    private SysRoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> queryRoleListWithSelected(Integer uid) {
        List<SysRole> sysRole = roleMapper.queryRoleListWithSelected(uid);
        if (CollectionUtils.isEmpty(sysRole)) {
            return null;
        }
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map ;
        for (SysRole role : sysRole) {
            map = new HashMap<>(3);
            map.put("id", role.getId());
            map.put("pId", 0);
            map.put("checked", role.getSelected() != null && role.getSelected() == 1);
            map.put("name", role.getDescription());
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public PageInfo<RoleExtend> findPageBreakByCondition(RoleConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysRole> sysRoles = roleMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(sysRoles)) {
            return null;
        }
        List<RoleExtend> roles = new ArrayList<>();
        for (SysRole r : sysRoles) {
            roles.add(new RoleExtend(r));
        }
        PageInfo bean = new PageInfo<SysRole>(sysRoles);
        bean.setList(roles);
        return bean;
    }

    @Override
    public List<RoleExtend> listRolesByUserId(Long userId) {
        List<SysRole> sysRoles = roleMapper.listRolesByUserId(userId);
        if (CollectionUtils.isEmpty(sysRoles)) {
            return null;
        }
        List<RoleExtend> roles = new ArrayList<>();
        for (SysRole r : sysRoles) {
            roles.add(new RoleExtend(r));
        }
        return roles;
    }

    @Override
    public PageInfo<RoleExtend> findPageBreakByCondition(Long aLong) throws Exception {
        return null;
    }

    @Override
    public boolean insert(RoleExtend entity) throws Exception {
        Assert.notNull(entity, "Role不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        roleMapper.insert(entity.getSysRole());
        return true;
    }

    @Override
    public boolean updateById(RoleExtend entity) throws Exception {
        Assert.notNull(entity, "Role不可为空！");
        entity.setUpdateTime(new Date());
        return roleMapper.updateById(entity.getSysRole()) > 0;
    }

    @Override
    public void deleteBatchIds(Long[] ids) throws Exception {
        roleMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public RoleExtend getByPrimaryKey(Long id) throws Exception {
        Assert.notNull(id, "PrimaryKey不可为空！");
        SysRole sysRole = roleMapper.selectById(id);
        return null == sysRole ? null : new RoleExtend(sysRole);
    }
}