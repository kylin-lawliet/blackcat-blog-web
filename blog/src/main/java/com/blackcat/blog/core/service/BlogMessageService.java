package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogMessage;

/**
 * <p> 消息通知表 服务类
 * @author blackcat
 * @date 2020-03-14
 */
public interface BlogMessageService extends IService<BlogMessage> {

    void add(Integer userId,Integer toUserId,Long articleId,int event);
}
