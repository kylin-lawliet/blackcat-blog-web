package com.blackcat.blog.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogMessage;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.service.BlogMessageService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.core.vo.MessageVo;
import com.blackcat.blog.util.RedisUtil;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p> 消息通知表 前端控制器
 * @author blackcat
 * @date 2020-03-14
 */
@RestController
@RequestMapping("/message")
public class BlogMessageController {

    @Resource
    private BlogMessageService iBlogMessageService;
    @Resource
    private RedisUtil redisUtil;

    /**
    * <p> 描述 : 获取列表数据
    * @author : blackcat
    * @date  : 2020-03-14
    */
    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        PageInfo<MessageVo> pageInfo = iBlogMessageService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }


    /**
    * <p> 描述 : 删除
    * @author : blackcat
    * @date  : 2020-03-14
    */
    @PostMapping(value = "/remove")
    public ResultUtil remove(Long[] ids) {
        if (null == ids) {
           return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
        }
        iBlogMessageService.remove(new UpdateWrapper<BlogMessage>().in("id", ids));
        redisUtil.deleteSub(RedisKey.MESSAGE,ids);
        return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
    }

    /**
    * <p> 描述 : 获取详情
    * @author : blackcat
    * @date  : 2020-03-14
    */
    @PostMapping("/get/{id}")
    public ResultUtil get(@PathVariable Long id) {
        BlogMessage message;
        if(redisUtil.hasKey(RedisKey.MESSAGE+id)){
            message = redisUtil.get(RedisKey.MESSAGE + id, BlogMessage.class);
        }else{
            message = iBlogMessageService.getById(id);
        }
        return ResultUtil.ok().put("data",message);
    }

}
