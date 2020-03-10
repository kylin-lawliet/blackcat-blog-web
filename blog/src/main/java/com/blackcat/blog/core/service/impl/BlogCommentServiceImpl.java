package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogComment;
import com.blackcat.blog.core.mapper.BlogCommentMapper;
import com.blackcat.blog.core.service.BlogCommentService;
import com.blackcat.blog.core.vo.CommentConditionVO;
import com.blackcat.blog.core.vo.CommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * <p> 博客评论表 服务实现类
 * @author blackcat
 * @date 2020-03-08
 */
@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

    @Resource
    private BlogCommentMapper blogCommentMapper;

    @Override
    public List<CommentVo> findAll(CommentConditionVO vo) {
        List<CommentVo> all=blogCommentMapper.findAll(vo);
        // 根节点
        List<CommentVo> root = new ArrayList<>();
        // 找到根节点
        all.forEach(comment->{
            if(comment.getParentId()==null){
                root.add(comment);
            }
        });
        root.forEach(comment->{
            List<CommentVo> childCodes=getChild(comment.getId(),all);
            comment.setNodes(childCodes);
        });
        Collections.sort(root);
        return root;
    }

    /**
     * <p> 描述 : 递归设置的子节点
     * @author : blackcat
     * @date  : 2020/3/10 14:20
     * @param id id
     * @param allCode  所有数据
     * @return java.util.List
     */
    private List<CommentVo> getChild(Long id,List<CommentVo> allCode) {
        //子菜单
        List<CommentVo> childList = new ArrayList<>();
        // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
        allCode.forEach(code->{
            if (code.getParentId() != null && code.getParentId().equals(id)) {
                childList.add(code);
            }
        });
        // 递归子节点
        childList.forEach(child->{
            child.setNodes(getChild(child.getId(),allCode));
        });
        Collections.sort(childList);
        // 如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

    @Override
    public PageInfo<CommentVo> findPageBreakByCondition(CommentConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<CommentVo> list = blogCommentMapper.findAll(vo);
        PageInfo<CommentVo> bean = new PageInfo<>(list);
        bean.setList(list);
        return bean;
    }
}
