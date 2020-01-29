package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.common.base.AbstractService;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.extend.RoleExtend;
import com.blackcat.blog.core.vo.RoleConditionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p> 角色业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:14
*/
public interface SysRoleService extends AbstractService<RoleExtend, Long> {

    /**
     * 获取ztree使用的角色列表
     *
     * @param uid
     * @return
     */
    List<Map<String, Object>> queryRoleListWithSelected(Integer uid);

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<RoleExtend> findPageBreakByCondition(RoleConditionVO vo);

    /**
     * 获取用户的角色
     *
     * @param userId
     * @return
     */
    List<RoleExtend> listRolesByUserId(Long userId);
}

