package com.blackcat.blog.controller;

import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.extend.RoleExtend;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysRoleMenuService;
import com.blackcat.blog.core.service.SysRoleService;
import com.blackcat.blog.core.vo.ResponseVO;
import com.blackcat.blog.core.vo.RoleConditionVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 系统角色管理
 *
 * @author zjjlive)
 * @version 1.0
 * @website https://www.foreknow.me
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/roles")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysRoleMenuService roleResourcesService;

//    @RequiresPermissions("roles")
    @PostMapping("/list")
    public PageResult getAll(RoleConditionVO vo) {
        PageInfo<RoleExtend> pageInfo = roleService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    //@RequiresPermissions("user:allotRole")
    @PostMapping("/rolesWithSelected")
    public ResponseVO<List<RoleExtend>> rolesWithSelected(Integer uid) {
        return ResultUtil.success(null, roleService.queryRoleListWithSelected(uid));
    }

   // @RequiresPermissions("role:allotResource")
    @PostMapping("/saveRoleResources")
    public ResponseVO saveRoleResources(Long roleId, String resourcesId) {
        if (StringUtils.isEmpty(roleId)) {
            return ResultUtil.error("error");
        }
        roleResourcesService.addRoleMenu(roleId, resourcesId);
        // 重新加载所有拥有roleId的用户的权限信息
        //shiroService.reloadAuthorizingByRoleId(roleId);
        return ResultUtil.success("成功");
    }

    //@RequiresPermissions("role:add")
    @PostMapping(value = "/add")
    public ResponseVO add(RoleExtend role) {
        //roleService.insert(role);
        return ResultUtil.success("成功");
    }

   // @RequiresPermissions(value = {"role:batchDelete", "role:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        roleResourcesService.deleteBatchIds(ids);
        return ResultUtil.success("成功删除 [" + ids.length + "] 个角色");
    }

    //@RequiresPermissions("role:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) throws Exception {
        return ResultUtil.success(null, this.roleService.getByPrimaryKey(id));
    }

    //@RequiresPermissions("role:edit")
    @PostMapping("/edit")
    public ResponseVO edit(RoleExtend role) {
        try {
            roleService.updateById(role);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("角色修改失败！");
        }
        return ResultUtil.success(ResponseStatusEnum.SUCCESS);
    }

}
