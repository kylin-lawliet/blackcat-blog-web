package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.SysRoleService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p> 角色表 前端控制器
 * @author blackcat
 * @date 2020-01-29
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Resource
    private SysRoleService iSysRoleService;

    @PostMapping("/rolesWithSelected")
    public ResultUtil rolesWithSelected(Integer uid) {
        return ResultUtil.ok().put("data",iSysRoleService.queryRoleListWithSelected(uid));
    }

    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        Page<SysRole> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda()
                    .like(SysRole::getDescription,vo.getKeywords())
                    .orderByDesc(SysRole::getCreateTime);
        }
        iSysRoleService.page(page, queryWrapper);
        return ResultUtil.tablePage(page);
    }

     @PostMapping(value = "/add")
     public ResultUtil add(SysRole entity) {
         iSysRoleService.save(entity);
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }

     @PostMapping(value = "/remove")
     public ResultUtil remove(Long[] ids) {
         if (null == ids) {
         return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
         }
         iSysRoleService.deleteBatchIds(ids);
         return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
     }

     @PostMapping("/get/{id}")
     public ResultUtil get(@PathVariable Long id) {
         return ResultUtil.ok().put("data",iSysRoleService.getById(id));
     }

     @PostMapping("/edit")
     public ResultUtil edit(SysRole entity) {
         try {
             iSysRoleService.updateById(entity);
         } catch (Exception e) {
             e.printStackTrace();
             return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
         }
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }
}
