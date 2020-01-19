package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.mapper.SysUserMapper;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 系统用户业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:17
*/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020/1/18 15:00
    */
    @Override
    public PageInfo<UserExtend> findPageBreakByCondition(UserConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(sysUsers)) {
            return null;
        }
        List<UserExtend> users = new ArrayList<>();
        for (SysUser su : sysUsers) {
            users.add(new UserExtend(su));
        }
        PageInfo bean = new PageInfo<>(sysUsers);
        bean.setList(users);
        return bean;
    }

    /**
     * <p> 根据用户名查询实体
     * @author : blackcat
     * @date : 2020/1/16 20:17
     * @Param [username:用户名]
     * @return 用户实体
    */
    /*@Override
    public SysUser selectUserByName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }*/
}