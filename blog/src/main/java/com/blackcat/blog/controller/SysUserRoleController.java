package com.blackcat.blog.controller;


import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysUserRoleService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        PageInfo<SysUserRole> pageInfo = iSysUserRoleService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

     @PostMapping(value = "/add")
     public ResultUtil add(SysUserRole entity) {
         iSysUserRoleService.save(entity);
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }

     @PostMapping(value = "/remove")
     public ResultUtil remove(Long[] ids) {
         if (null == ids) {
         return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
         }
         iSysUserRoleService.deleteBatchIds(ids);
         return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
     }

     @PostMapping("/get/{id}")
     public ResultUtil get(@PathVariable Long id) {
         return ResultUtil.ok().put("data",iSysUserRoleService.getById(id));
     }

     @PostMapping("/edit")
     public ResultUtil edit(SysUserRole entity) {
         try {
             iSysUserRoleService.updateById(entity);
         } catch (Exception e) {
             e.printStackTrace();
             return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
         }
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }
}
