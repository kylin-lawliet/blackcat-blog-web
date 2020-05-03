package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.BlogMessage;
import com.blackcat.blog.core.vo.BaseConditionVO;
import com.blackcat.blog.core.vo.MessageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p> 消息通知表 服务类
 * @author blackcat
 * @date 2020-03-14
 */
public interface BlogMessageService extends IService<BlogMessage> {

    /**
     * <p> 描述 : 修改消息状态
     * @author : blackcat
     * @date  : 2020/5/3 15:13
     * @param articleId
     * @return void
    */
    void updateStatus(Long articleId);

    /**
     * <p> 描述 : 添加通知消息
     * @author : blackcat
     * @date  : 2020/4/27 17:02
     * @param userId 创建用户
     * @param toUserId 发送用户
     * @param articleId 文章编号
     * @param event 事件
     * @return void
    */
    void add(Integer userId,Integer toUserId,Long articleId,int event);

    /**
     * <p> 描述 : 根据条件查询消息
     * @author : blackcat
     * @date  : 2020/5/2 15:59
     * @param map  条件查询
     * @return java.util.List<com.blackcat.blog.core.vo.MessageVo>
     */
    List<MessageVo> findAllByCondition(Map<String,Object> map);

    /**
     * <p> 描述 : 分页查询
     * @author : blackcat
     * @date  : 2020/5/2 16:05
    */
    PageInfo<MessageVo> findPageBreakByCondition(BaseConditionVO vo);
}
