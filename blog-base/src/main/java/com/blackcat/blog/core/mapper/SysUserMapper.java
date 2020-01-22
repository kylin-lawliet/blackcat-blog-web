package com.blackcat.blog.core.mapper;


import com.blackcat.blog.common.base.BaseIMapper;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.vo.UserConditionVO;

import java.util.List;

/**
 * <p> 用户Mapper
 * @author : blackcat
 * @serialData : 2020/1/16 20:10
*/
public interface SysUserMapper extends BaseIMapper<SysUser,UserConditionVO> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @serialData : 2020/1/18 14:57
     * @param [vo]
     * @return List<SysUser>
    */
    @Override
    List<SysUser> findPageBreakByCondition(UserConditionVO vo);
}
