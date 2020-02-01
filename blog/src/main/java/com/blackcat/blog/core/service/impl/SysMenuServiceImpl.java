package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.mapper.SysMenuMapper;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;


/**
 * <p> 权限表 服务实现类
 * @author blackcat
 * @date 2020-01-29
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map<String, Object>> queryMenuListWithSelected(Long rid) {
        List<SysMenu> sysMenus = sysMenuMapper.queryMenuListWithSelected(rid);
        List<Map<String, Object>> mapList = new ArrayList<>(sysMenus.size());
        if (!CollectionUtils.isEmpty(sysMenus)) {
            Map<String, Object> map ;
            for (SysMenu resources : sysMenus) {
                map = new HashMap<>(7);
                map.put("id", resources.getId());
                map.put("pId", resources.getParentId());
                map.put("checked", resources.getChecked());
                map.put("name", resources.getName());
                mapList.add(map);
            }
        }
        return mapList;
    }

    @Override
    public List<SysMenu> listAllAvailableMenu() {
        return sysMenuMapper.listAllAvailableMenu();
    }

    @Override
    public List<SysMenu> listUserMenu(Map<String, Object> map) {
        return sysMenuMapper.listUserMenu(map);
    }

    @Override
    public PageInfo<SysMenu> findPageBreakByCondition(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysMenu> list = sysMenuMapper.findPageBreakByCondition(vo);
        PageInfo<SysMenu> bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        sysMenuMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
