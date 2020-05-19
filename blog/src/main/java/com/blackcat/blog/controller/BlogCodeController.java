package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogCodeService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.util.RedisUtil;
import com.blackcat.blog.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private RedisUtil redisUtil;

    /**
     * <p> 描述 : 码表数据
     * - - - 递归获取所有子节点
     * @author : blackcat
     * @date  : 2020/3/4 15:56
     * @param id
     * @return com.blackcat.blog.util.ResultUtil
    */
    @RequestMapping("/getCodesByCodeListId/{id}")
    public ResultUtil getCodesByCodeListId(@PathVariable Long id) {
        List<BlogCode> list ;
        if(redisUtil.hasKey(RedisKey.CODE_ALL+id)){
            list = redisUtil.get(RedisKey.CODE_ALL + id,BlogCode.class);
        }else{
            list = iBlogCodeService.getCodesByCodeListId(id.toString());
            redisUtil.set(RedisKey.CODE_ALL + id,list,30, TimeUnit.MINUTES);
        }
        return ResultUtil.ok().put("data",list);
    }

    /**
     * <p> 描述 : 获取所有分类json字符串
     * @author : blackcat
     * @date  : 2020/3/2 16:43
    */
    @RequestMapping("/allJson/{id}")
    public ResultUtil allJson(@PathVariable Long id) {
        List<BlogCode> list;
        if(redisUtil.hasKey(RedisKey.CODE_ALL_JSON)){
            list = redisUtil.get(RedisKey.CODE_ALL_JSON + id, BlogCode.class);
        }else{
            QueryWrapper<BlogCode> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(BlogCode::getCodeId, id);
            list =iBlogCodeService.list(queryWrapper);
            redisUtil.set(RedisKey.CODE_ALL_JSON + id, list,30, TimeUnit.MINUTES);
        }
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
        queryWrapper.lambda().orderByAsc(BlogCode::getParentId).orderByAsc(BlogCode::getSort);
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
        redisUtil.set(RedisKey.CODE+id,entity);
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
        redisUtil.deleteSub(RedisKey.CODE,ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 获取详情
    * @author : blackcat
    * @date  : 2020-02-26
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        BlogCode code;
        if(redisUtil.hasKey(RedisKey.CODE+id)){
            code = redisUtil.get(RedisKey.CODE + id,BlogCode.class);
        }else{
            code = iBlogCodeService.getById(id);
            redisUtil.set(RedisKey.CODE+id,code);
        }
        return ResultUtil.ok().put("data",code);
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
            redisUtil.set(RedisKey.CODE+entity.getId(),entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
        }
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
