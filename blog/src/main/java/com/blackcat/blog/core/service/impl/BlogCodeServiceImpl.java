package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogCode;
import com.blackcat.blog.core.mapper.BlogCodeMapper;
import com.blackcat.blog.core.service.BlogCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


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
//        QueryWrapper<BlogCode> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(BlogCode::getCodeId, id);
//        return blogCodeMapper.selectList(queryWrapper);
        return blogCodeMapper.listCodeByType(id);
    }
}
