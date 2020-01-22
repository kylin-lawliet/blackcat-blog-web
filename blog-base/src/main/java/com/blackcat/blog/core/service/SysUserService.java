package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.common.base.AbstractService;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.github.pagehelper.PageInfo;

/**
 * <p> 用户业务接口
 * @author : blackcat
 * @serialData : 2020/1/16 20:15
*/
public interface SysUserService extends AbstractService<UserExtend,UserConditionVO> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @serialData : 2020/1/18 14:59
     * @param [vo:条件属性]
     * @return PageInfo<UserExtend>
    */
    //PageInfo<UserExtend> findPageBreakByCondition(UserConditionVO vo);

    /**
     * <p> 根据用户名查询实体
     * @author : blackcat
     * @serialData : 2020/1/16 20:14
     * @param [username:用户名]
     * @return 用户实体
    */
    //SysUser selectUserByName(String username);

}

