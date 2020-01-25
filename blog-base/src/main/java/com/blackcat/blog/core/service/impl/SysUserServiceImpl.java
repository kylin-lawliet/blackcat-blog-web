package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.common.CommonMethod;
import com.blackcat.blog.common.base.AbstractServiceImpl;
import com.blackcat.blog.common.exception.BlogException;
import com.blackcat.blog.common.holder.RequestHolder;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.enums.UserStatusEnum;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.core.extend.UserExtend;
import com.blackcat.blog.core.mapper.SysUserMapper;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.core.vo.UserConditionVO;
import com.blackcat.blog.util.IpUtil;
import com.blackcat.blog.util.PasswordUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p> 系统用户业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:17
*/
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<UserExtend> findPageBreakByCondition(UserConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.findPageBreakByCondition(vo);
        List<UserExtend> users =  getResources(sysUsers);
        PageInfo bean = new PageInfo<>(sysUsers);
        bean.setList(users);
        return bean;
    }

    @Override
    public UserExtend updateUserLastLoginInfo(UserExtend user) {
        if (user != null) {
            user.setLoginCount(user.getLoginCount() + 1);
            user.setLastLoginTime(new Date());
            user.setLastLoginIp(IpUtil.getRealIp(RequestHolder.getRequest()));
            user.setPassword(null);
            this.updateById(user);
        }
        return user;
    }

    @Override
    public UserExtend getByUserName(String userName) {
        UserExtend user = new UserExtend(userName, null);
//        sysUserMapper.selectOne()
//        return getOneByEntity(user  );
        return user;
    }

    @Override
    public List<UserExtend> listByRoleId(Long roleId) {
        List<SysUser> sysUsers = sysUserMapper.listByRoleId(roleId);
        return getResources(sysUsers);
    }

    /**
     * <p> : 将系统权限类转为扩展类
     * @author : blackcat
     * @date : 2020/1/17 14:27
     * @param sysUsers 系统权限类
     * @return List<MenuExtend> 集合
     */
    private List<UserExtend> getResources(List<SysUser> sysUsers) {
        if (CollectionUtils.isEmpty(sysUsers)) {
            return null;
        }
        List<UserExtend> resources = new ArrayList<>();
        for (SysUser user : sysUsers) {
            resources.add(new UserExtend(user));
        }
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(UserExtend entity) {
        Assert.notNull(entity, "User不可为空！");
        entity.setUpdateTime(new Date());
        entity.setCreateTime(new Date());
        entity.setRegIp(IpUtil.getRealIp(RequestHolder.getRequest()));
        entity.setStatus(UserStatusEnum.NORMAL.getCode());
        return CommonMethod.retBool(sysUserMapper.insert(entity.getSysUser()));
    }

    @Override
    public boolean updateById(UserExtend entity) {
        Assert.notNull(entity, "User不可为空！");
        entity.setUpdateTime(new Date());
        if (!StringUtils.isEmpty(entity.getPassword())) {
            try {
                entity.setPassword(PasswordUtil.encrypt(entity.getPassword(), entity.getUsername()));
            } catch (Exception e) {
                throw new BlogException("密码加密失败");
            }
        }
        return CommonMethod.retBool(sysUserMapper.updateById(entity.getSysUser()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatchIds(Long[] ids) {
        sysUserMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public UserExtend getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysUser sysUser = sysUserMapper.selectById(primaryKey);
        return null == sysUser ? null : new UserExtend(sysUser);
    }
}