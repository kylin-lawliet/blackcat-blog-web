package com.blackcat.blog.controller;


import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.ShiroService;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p> 权限表 前端控制器
 * @author blackcat
 * @date 2020-01-29
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Resource
    private SysMenuService iSysMenuService;
    @Resource
    protected ShiroService shiroService;

    /**
     * <p> 描述 : 角色分配资源查询
     * @author : blackcat
     * @date  : 2020/2/6 16:07   
    */
    @RequiresPermissions("role:allotMenu")
    @PostMapping("/menuWithSelected")
    public ResultUtil menuWithSelected(Long rid) {
        return ResultUtil.ok().put("data", iSysMenuService.queryMenuListWithSelected(rid));
    }

    /**
     * <p> 描述 : 获取列表数据
     * @author : blackcat
     * @date  : 2020/2/6 16:11
    */
    @RequiresPermissions("menus")
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        PageInfo<SysMenu> pageInfo = iSysMenuService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * <p> 描述 : 添加菜单资源
     * @author : blackcat
     * @date  : 2020/2/6 16:13
    */
    @RequiresPermissions("menu:add")
    @PostMapping(value = "/add")
    public ResultUtil add(SysMenu menu) {
        if (iSysMenuService.save(menu)) {
            //更新权限
            shiroService.updatePermission();
            return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
        } else {
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }

    }

    /**
     * <p> 描述 : 删除
     * @author : blackcat
     * @date  : 2020/2/6 16:14
    */
    @RequiresPermissions(value = {"menu:batchDelete", "menu:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iSysMenuService.deleteBatchIds(ids);
        //更新权限
        shiroService.updatePermission();
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
     * <p> 描述 : 获取详情
     * @author : blackcat
     * @date  : 2020/2/6 16:16
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        return ResultUtil.ok().put("data",iSysMenuService.getById(id));
    }

    /**
     * <p> 描述 : 编辑
     * @author : blackcat
     * @date  : 2020/2/6 16:17
    */
    @PostMapping("/edit")
    public ResultUtil edit(SysMenu menu) {
        try {
            iSysMenuService.updateById(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
    }
}
