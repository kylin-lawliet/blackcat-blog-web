package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogMessage;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.mapper.BlogMessageMapper;
import com.blackcat.blog.core.service.BlogMessageService;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.core.vo.MessageVo;
import com.blackcat.blog.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p> 消息通知表 服务实现类
 * @author blackcat
 * @date 2020-03-14
 */
@Service
public class BlogMessageServiceImpl extends ServiceImpl<BlogMessageMapper, BlogMessage> implements BlogMessageService {

    @Resource
    BlogMessageMapper messageMapper;
    @Resource
    private RedisUtil redisUtil;

    private static String COMMENT="评论了你的文章";
    private static String REPLY="回复了你的评论";

    @Override
    public void updateStatus(Long articleId) {
        UpdateWrapper<BlogMessage> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().in(BlogMessage::getArticleId, articleId);
        updateWrapper.setSql("status = 1");
        messageMapper.update(null,updateWrapper);
    }

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
        redisUtil.set(RedisKey.MESSAGE+message.getId(),message);
    }

    @Override
    public List<MessageVo> findAllByCondition(Map<String, Object> map) {
        return messageMapper.findAllByCondition(map);
    }

    @Override
    public PageInfo<MessageVo> findPageBreakByCondition(BaseConditionVO vo) {
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser= (SysUser) subject.getPrincipal();
        Map<String, Object> params = new HashMap<>(2);
        params.put("userId", sysUser.getId());
        params.put("keywords", vo.getKeywords());

        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MessageVo> list = messageMapper.findAllByCondition(params);
        PageInfo<MessageVo> bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }
}
