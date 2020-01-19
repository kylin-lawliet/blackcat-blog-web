package com.blackcat.blog.core.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.vo.UserConditionVO;

import java.util.List;

/**
 * <p> 用户Mapper
 * @author : blackcat
 * @date : 2020/1/16 20:10
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020/1/18 14:57
     * @Param [vo]
     * @return List<SysUser>
    */
    List<SysUser> findPageBreakByCondition(UserConditionVO vo);
}
