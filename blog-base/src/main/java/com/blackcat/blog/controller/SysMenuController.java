package com.blackcat.blog.controller;

import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysMenuService;
import com.blackcat.blog.core.vo.MenuConditionVO;
import com.blackcat.blog.core.vo.ResponseVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> ：权限管理
 * @author : blackcat
 * @serialData : 2020/1/17 14:06
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService menuService;

    /**
     * <p> : 获取权限管理页面数据
     * @author : blackcat
     * @serialData : 2020/1/20 16:46
    */
    //@RequestMapping("/list")
    @PostMapping("/list")
    public PageResult getAll(MenuConditionVO vo) {
        PageInfo<MenuExtend> pageInfo = menuService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    //@RequiresPermissions("resource:add")
    @PostMapping(value = "/add")
    public ResponseVO add(MenuExtend menu) {
        menuService.insert(menu);
        //更新权限
        //shiroService.updatePermission();
        return ResultUtil.success("成功");
    }

    //@RequiresPermissions(value = {"resource:batchDelete", "resource:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        menuService.deleteBatchIds(ids);
        //更新权限
        //shiroService.updatePermission();
        return ResultUtil.success("成功删除 [" + ids.length + "] 个资源");
    }

    //@RequiresPermissions("resource:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.menuService.getByPrimaryKey(id));
    }

    //@RequiresPermissions("resource:edit")
    @PostMapping("/edit")
    public ResponseVO edit(MenuExtend menu) {
        try {
            menuService.updateById(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("资源修改失败！");
        }
        return ResultUtil.success(ResponseStatusEnum.SUCCESS);
    }
}
