package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.BlogArticleTag;
import com.blackcat.blog.core.mapper.BlogArticleTagMapper;
import com.blackcat.blog.core.service.BlogArticleTagService;
import org.springframework.stereotype.Service;


/**
 * <p> 文章标签关联类 服务实现类
 * @author blackcat
 * @date 2020-03-01
 */
@Service
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagMapper, BlogArticleTag> implements BlogArticleTagService {

}
