package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.BlogMessage;
import com.blackcat.blog.core.vo.MessageVo;

import java.util.List;
import java.util.Map;

/**
 * <p> 消息通知表 Mapper 接口
 * @author blackcat
 * @date 2020-03-14
 */
public interface BlogMessageMapper extends BaseMapper<BlogMessage> {

    /**
     * <p> 描述 : 根据条件查询消息
     * @author : blackcat
     * @date  : 2020/5/2 15:59
     * @param map  条件查询
     * @return java.util.List<com.blackcat.blog.core.vo.MessageVo>
    */
    List<MessageVo> findAllByCondition(Map<String,Object> map);
}
