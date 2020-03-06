package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.mapper.BlogCodeMapper;
import com.blackcat.blog.core.service.BlogCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * <p> 博客分类码表 服务实现类
 * @author blackcat
 * @date 2020-02-26
 */
@Service
public class BlogCodeServiceImpl extends ServiceImpl<BlogCodeMapper, BlogCode> implements BlogCodeService {

    @Resource
    private BlogCodeMapper blogCodeMapper;

    @Override
    public void deleteBatchIds(Long[] ids) {
        blogCodeMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public List<BlogCode> getParents(String id) {
        return blogCodeMapper.listCodeByType(id);
    }

    @Override
    public List<BlogCode> getCodesByCodeListId(String id) {
        // 该分类下所有码表数据
        QueryWrapper<BlogCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogCode::getCodeId, id);
        List<BlogCode> allCode=blogCodeMapper.selectList(queryWrapper);
        // 根节点
        List<BlogCode> rootCode = new ArrayList<BlogCode>();
        // 找到根节点
        allCode.forEach(code->{
            if(code.getParentId()==null){
                rootCode.add(code);
            }
        });
        Collections.sort(rootCode);
        //为根节点设置子节点，getClild是递归调用的
        rootCode.forEach(code->{
            List<BlogCode> childCodes=getChild(code.getId(),allCode);
            code.setNodes(childCodes);
        });
        return rootCode;
    }

    /**
     * <p> 描述 : 递归设置栏目的子节点
     * @author : blackcat
     * @date  : 2020/3/5 14:20
     * @param id 码表id
     * @param allCode  所有码表数据
     * @return java.util.List<com.blackcat.blog.core.entity.BlogCode>
    */
    private List<BlogCode> getChild(Long id,List<BlogCode> allCode) {
        //子菜单
        List<BlogCode> childList = new ArrayList<BlogCode>();
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
            return new ArrayList<BlogCode>();
        }
        return childList;
    }
}
