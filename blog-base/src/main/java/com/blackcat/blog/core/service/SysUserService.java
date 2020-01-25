package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.common.base.AbstractService;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.object.AbstractIService;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p> 用户业务接口
 * @author : blackcat
 * @date : 2020/1/16 20:15
*/
public interface SysUserService extends AbstractIService<UserExtend, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<UserExtend> findPageBreakByCondition(UserConditionVO vo);

    /**
     * 更新用户最后一次登录的状态信息
     *
     * @param user
     * @return
     */
    UserExtend updateUserLastLoginInfo(UserExtend user);

    /**
     * 根据用户名查找
     *
     * @param userName
     * @return
     */
    UserExtend getByUserName(String userName);

    /**
     * 通过角色Id获取用户列表
     *
     * @param roleId
     * @return
     */
    List<UserExtend> listByRoleId(Long roleId);
}

