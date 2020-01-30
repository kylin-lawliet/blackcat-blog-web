package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.vo.BaseConditionVO;

import java.util.List;
/**
 * <p> 角色与权限关系表 Mapper 接口
 * @author blackcat
 * @date 2020-01-29
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020-01-29
     * @param vo 条件封装
     * @return  List<SysMenu>
     */
    List<SysRoleMenu> findPageBreakByCondition(BaseConditionVO vo);
}
