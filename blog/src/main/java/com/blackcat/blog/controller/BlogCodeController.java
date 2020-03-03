package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> 博客分类码表 前端控制器
 * @author blackcat
 * @date 2020-02-26
 */
@RestController
@RequestMapping("/code")
public class BlogCodeController {

    @Resource
    private BlogCodeService iBlogCodeService;

    /**
     * <p> 描述 : 获取所有分类json字符串
     * @author : blackcat
     * @date  : 2020/3/2 16:43
    */
    @RequestMapping("/allJson/{id}")
    public ResultUtil allJson(@PathVariable Long id) {
        QueryWrapper<BlogCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogCode::getCodeId, id);
        List<BlogCode> list =iBlogCodeService.list(queryWrapper);
        return ResultUtil.ok().put("data",list);
    }

    /**
    * <p> 描述 : 获取列表数据
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @RequestMapping("/list/{id}")
    public PageResult list(@PathVariable Long id, BaseConditionVO vo){
        Page<BlogCode> page = new Page<>(vo.getPageNumber(), vo.getPageSize());
        QueryWrapper<BlogCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogCode::getCodeId, id);
        if(StringUtils.isNotBlank(vo.getKeywords())){
            queryWrapper.lambda().
                    like(BlogCode::getName, vo.getKeywords())
                    .or().like(BlogCode::getRemarks, vo.getKeywords());
        }
        queryWrapper.lambda().orderByAsc(BlogCode::getSort);
        iBlogCodeService.page(page, queryWrapper);
        return ResultUtil.tablePage(page);
    }

    /**
    * <p> 描述 : 添加
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @PostMapping(value = "/add/{id}")
    public ResultUtil add(@PathVariable Long id,BlogCode entity) {
        entity.setCodeId(id);
        iBlogCodeService.save(entity);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

    /**
    * <p> 描述 : 删除
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iBlogCodeService.deleteBatchIds(ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 获取详情
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        return ResultUtil.ok().put("data",iBlogCodeService.getById(id));
    }

    /**
    * <p> 描述 : 编辑
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @PostMapping("/edit")
    public ResultUtil edit(BlogCode entity) {
        try {
            iBlogCodeService.updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
