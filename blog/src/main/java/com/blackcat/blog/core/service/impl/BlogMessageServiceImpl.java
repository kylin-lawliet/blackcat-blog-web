package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogMessage;
import com.blackcat.blog.core.mapper.BlogMessageMapper;
import com.blackcat.blog.core.service.BlogMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;


/**
 * <p> 消息通知表 服务实现类
 * @author blackcat
 * @date 2020-03-14
 */
@Service
public class BlogMessageServiceImpl extends ServiceImpl<BlogMessageMapper, BlogMessage> implements BlogMessageService {

    @Resource
    BlogMessageMapper messageMapper;

    private static String COMMENT="评论了你的文章";
    private static String REPLY="回复了你的评论";

    @Override
    public void add(Integer userId, Integer toUserId, Long articleId, int event) {
        BlogMessage message=new BlogMessage();
        message.setArticleId(articleId);
        message.setCreateTime(LocalDateTime.now());
        message.setToUserId(toUserId);
        message.setUserId(userId);
        message.setStatus(0);
        message.setEvent(event);
        switch (event) {
            case 1:
                message.setMessage(COMMENT);
                break;
            case 2:
                message.setMessage(REPLY);
                break;
            default:
                break;
        }
        messageMapper.insert(message);
    }
}
