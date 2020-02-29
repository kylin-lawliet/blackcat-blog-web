package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.service.ShiroService;
import com.blackcat.blog.core.service.SysRoleMenuService;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 角色与权限关系表 前端控制器
 * @author blackcat
 * @date 2020-01-29
 */
@RestController
@RequestMapping("/role-menu")
public class SysRoleMenuController {

    @Resource
    private SysRoleMenuService iSysRoleMenuService;
    @Resource
    protected ShiroService shiroService;

    /**
     * <p> 描述 : 添加角色资源
     * @author : blackcat
     * @date  : 2020/1/31 10:18
     * @param roleId 角色Id
     * @param menuId 资源Id 此处获取的参数的角色id是以 “,” 分隔的字符串
     */
    @PostMapping("/saveRoleMenus")
    public ResultUtil saveRoleMenus(Long roleId, String menuId) {
        if (StringUtils.isNotBlank(menuId)) {
            String[] resourcesArr = menuId.split(",");
            UpdateWrapper<SysRoleMenu> updateWrapper  = new UpdateWrapper<>();
            updateWrapper.eq("role_id", roleId);
            updateWrapper.in("menu_id",resourcesArr);
            iSysRoleMenuService.remove(updateWrapper);
            if (resourcesArr.length > 0) {
                SysRoleMenu r ;
                List<SysRoleMenu> roleMenus = new ArrayList<>();
                for (String ri : resourcesArr) {
                    if (StringUtils.isNotBlank(ri)) {
                        r = new SysRoleMenu();
                        r.setRoleId(roleId);
                        r.setMenuId(Long.parseLong(ri));
                        r.setCreateTime(LocalDateTime.now());
                        r.setUpdateTime(LocalDateTime.now());
                        roleMenus.add(r);
                    }
                }
                iSysRoleMenuService.saveBatch(roleMenus);
                // 重新加载所有拥有roleId的用户的权限信息
                shiroService.reloadAuthorizingByRoleId(roleId);
            }
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
