package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.service.SysRoleService;
import com.blackcat.blog.core.service.SysUserRoleService;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p> 用户与角色关系表 前端控制器
 * @author blackcat
 * @date 2020-01-29
 */
@RestController
@RequestMapping("/user-role")
public class SysUserRoleController {

    @Resource
    private SysUserRoleService iSysUserRoleService;
    @Resource
    private SysUserService iSysUserService;
    @Resource
    private SysRoleService iSysRoleService;

    /**
     * <p> 描述 : 添加用户角色
     * @author : blackcat
     * @date  : 2020/1/31 10:11
     * @param userId 用户Id
     * @param roleIds  用户角色 此处获取的参数的角色id是以 “,” 分隔的字符串
     */
    @PostMapping("/saveUserRoles")
    public ResultUtil saveUserRoles(Long userId, String roleIds) {
        UpdateWrapper<SysUserRole> updateWrapper  = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userId);
        iSysUserRoleService.remove(updateWrapper);
        if(StringUtils.isNotBlank(roleIds)){
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(Long.parseLong(roleIds));
            iSysUserRoleService.save(userRole);

            SysRole role = iSysRoleService.getById(roleIds);
            SysUser sysUser = new SysUser();
            String rolename = "USER";
            if(role.getName().indexOf("root")!=-1){
                rolename = "TOOR";
            }
            if(role.getName().indexOf("admin")!=-1){
                rolename = "ADMIN";
            }
            sysUser.setUserType(rolename);
            iSysUserService.update(sysUser,new QueryWrapper<SysUser>().eq("id",userId));
        }


        /*String[] roleIdArr = roleIds.split(",");
        if (roleIdArr.length > 0) {
            SysUserRole userRole ;
            List<SysUserRole> roles = new ArrayList<>();
            for (String roleId : roleIdArr) {
                if (StringUtils.isNotBlank(roleId)) {
                    userRole = new SysUserRole();
                    userRole.setUserId(userId);
                    userRole.setRoleId(Long.parseLong(roleId));
                    roles.add(userRole);
                }
            }
            iSysUserRoleService.saveBatch(roles);
        }*/

        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

}
