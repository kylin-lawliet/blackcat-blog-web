package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysUserRole;
import com.blackcat.blog.core.vo.BaseConditionVO;

import java.util.List;
/**
 * <p> 用户与角色关系表 Mapper 接口
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020-01-29
     * @param vo 条件封装
     * @return  List<SysMenu>
     */
    List<SysUserRole> findPageBreakByCondition(BaseConditionVO vo);
}
