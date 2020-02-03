package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.mapper.SysRoleMapper;
import com.blackcat.blog.core.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;


/**
 * <p> 角色表 服务实现类
 * @author blackcat
 * @date 2020-01-29
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> listRolesByUserId(Integer userId) {
        return sysRoleMapper.listRolesByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> queryRoleListWithSelected(Integer uid) {
        List<SysRole> sysRole = sysRoleMapper.queryRoleListWithSelected(uid);
        if (CollectionUtils.isEmpty(sysRole)) {
            return null;
        }
        List<Map<String, Object>> mapList = new ArrayList(sysRole.size());
        Map<String, Object> map ;
        for (SysRole role : sysRole) {
            map = new HashMap<>(7);
            map.put("id", role.getId());
            map.put("pId", 0);
            map.put("checked", role.getSelected() != null && role.getSelected() == 1);
            map.put("name", role.getDescription());
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysRoleMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
