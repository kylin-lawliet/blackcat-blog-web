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
     * @param vo 封装
     * @return List<SysUser>
    */
    List<SysUser> findPageBreakByCondition(UserConditionVO vo);

    /**
     * <p> 描述 : 通过角色Id获取用户列表
     * @author : blackcat
     * @date  : 2020/1/25 16:57
    */
    List<SysUser> listByRoleId(Long roleId);
}
