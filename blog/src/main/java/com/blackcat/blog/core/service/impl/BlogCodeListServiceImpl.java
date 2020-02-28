package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogCodeList;
import com.blackcat.blog.core.mapper.BlogCodeListMapper;
import com.blackcat.blog.core.service.BlogCodeListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;


/**
 * <p> 分类码表总表 服务实现类
 * @author blackcat
 * @date 2020-02-27
 */
@Service
public class BlogCodeListServiceImpl extends ServiceImpl<BlogCodeListMapper, BlogCodeList> implements BlogCodeListService {

    @Resource
    private BlogCodeListMapper blogCodeListMapper;

    @Override
    public void deleteBatchIds(Long[] ids) {
        blogCodeListMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
