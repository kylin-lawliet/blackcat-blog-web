package com.blackcat.blog.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysUser;

import java.util.List;

/**
 * <p> ：通用Mapper
 * @author : blackcat
 * @date : 2020/1/21 10:15
 */
public interface BaseIMapper<T,BaseConditionVO> extends BaseMapper<T> {
    List<SysUser> findPageBreakByCondition(BaseConditionVO vo);
}
