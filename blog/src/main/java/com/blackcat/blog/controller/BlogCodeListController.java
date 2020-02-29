package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.entity.BlogCodeList;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogCodeListService;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p> 分类码表总表 前端控制器
 * @author blackcat
 * @date 2020-02-27
 */
@RestController
@RequestMapping("/code-list")
public class BlogCodeListController {

    @Resource
    private BlogCodeListService iBlogCodeListService;
    @Resource
    private BlogCodeService iBlogCodeService;

    /**
    * <p> 描述 : 获取列表数据
    * @author : blackcat
    * @date  : 2020-02-27
    */
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        Page<BlogCodeList> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<BlogCodeList> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda().
                    like(BlogCodeList::getName, vo.getKeywords())
                    .or().like(BlogCodeList::getRemarks, vo.getKeywords());
        }
        queryWrapper.lambda().orderByAsc(BlogCodeList::getSort);
        iBlogCodeListService.page(page, queryWrapper);
        return ResultUtil.tablePage(page);
    }

    /**
    * <p> 描述 : 添加
    * @author : blackcat
    * @date  : 2020-02-27
    */
    @PostMapping(value = "/add")
    public ResultUtil add(BlogCodeList entity) {
        iBlogCodeListService.save(entity);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

    /**
    * <p> 描述 : 删除
    * @author : blackcat
    * @date  : 2020-02-27
    */
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iBlogCodeService.remove(new UpdateWrapper<BlogCode>().in("code_id", ids));
        iBlogCodeListService.deleteBatchIds(ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 获取详情
    * @author : blackcat
    * @date  : 2020-02-27
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        return ResultUtil.ok().put("data",iBlogCodeListService.getById(id));
    }

    /**
    * <p> 描述 : 编辑
    * @author : blackcat
    * @date  : 2020-02-27
    */
    @PostMapping("/edit")
    public ResultUtil edit(BlogCodeList entity) {
        try {
            entity.setUpdateTime(LocalDateTime.now());
            iBlogCodeListService.updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
