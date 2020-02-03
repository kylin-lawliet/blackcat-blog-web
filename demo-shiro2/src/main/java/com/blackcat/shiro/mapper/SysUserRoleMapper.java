package com.blackcat.shiro.mapper;

import com.blackcat.shiro.entity.SysUserRole;
import com.blackcat.shiro.vo.BaseConditionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
/**
 * <p> 用户与角色关系表 Mapper 接口
 * @author blackcat
 * @date 2020-02-03
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020-02-03
     * @param vo 条件封装
     * @return  List<SysMenu>
     */
    List<SysUserRole> findPageBreakByCondition(BaseConditionVO vo);
}
