package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.common.CommonMethod;
import com.blackcat.blog.core.extend.RoleMenuExtend;
import com.blackcat.blog.core.mapper.SysRoleMenuMapper;
import com.blackcat.blog.core.entity.SysRoleMenu;
import com.blackcat.blog.core.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p> 角色与权限业务实现
 * @author : blackcat
 * @date : 2020/1/16 20:16
*/
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired(required = false)
    private SysRoleMenuMapper menuMapper;

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity
     * @return
     */
    @Override
    public boolean insert(RoleMenuExtend entity) {
        Assert.notNull(entity, "RoleMenuExtend不可为空！");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return  CommonMethod.retBool(menuMapper.insert(entity.getSysRoleMenu()));
    }


    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(RoleMenuExtend entity) {
        Assert.notNull(entity, "RoleMenuExtend不可为空！");
        entity.setUpdateTime(new Date());
        return menuMapper.updateById(entity.getSysRoleMenu()) > 0;
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        menuMapper.deleteBatchIds(Arrays.asList(ids));
    }


    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param primaryKey
     * @return
     */
    @Override
    public RoleMenuExtend getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        SysRoleMenu sysRoleMenuExtend = menuMapper.selectById(primaryKey);
        return null == sysRoleMenuExtend ? null : new RoleMenuExtend(sysRoleMenuExtend);
    }


//    /**
//     * 查询全部结果，listByEntity(null)方法能达到同样的效果
//     *
//     * @return
//     */
//    @Override
//    public List<RoleMenuExtend> listAll() {
//        List<SysRoleMenuExtend> sysRoleMenuExtend = menuMapper.selectAll();
//        return getRoleMenuExtend(sysRoleMenuExtend);
//    }

//    /**
//     * 根据实体中的属性值进行查询，查询条件使用等号
//     *
//     * @param entity
//     * @return
//     */
//    @Override
//    public List<RoleMenuExtend> listByEntity(RoleMenuExtend entity) {
//        Assert.notNull(entity, "RoleMenuExtend不可为空！");
//        List<SysRoleMenuExtend> sysRoleMenuExtend = menuMapper.select(entity.getSysRoleMenuExtend());
//        return getRoleMenuExtend(sysRoleMenuExtend);
//    }

//    private List<RoleMenuExtend> getRoleMenuExtend(List<RoleMenuExtend> roleMenuExtends) {
//        if (CollectionUtils.isEmpty(roleMenuExtends)) {
//            return null;
//        }
//        List<RoleMenuExtend> rr = new ArrayList<>();
//        for (SysRoleMenu r : roleMenuExtends) {
//            rr.add(new RoleMenuExtend(r));
//        }
//        return rr;
//    }

    /**
     * 添加角色资源
     * 该节代码参考自http://blog.csdn.net/poorcoder_/article/details/71374002
     *
     * @param roleId
     * @param resourcesIds
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void addRoleMenu(Long roleId, String resourcesIds) {
        //删除
        removeByRoleId(roleId);
        //添加
        if (!StringUtils.isEmpty(resourcesIds)) {
            String[] resourcesArr = resourcesIds.split(",");
            if (resourcesArr.length == 0) {
                return;
            }
            RoleMenuExtend r = null;
            List<RoleMenuExtend> RoleMenuExtend = new ArrayList<>();
            for (String ri : resourcesArr) {
                if (StringUtils.isEmpty(ri)) {
                    continue;
                }
                r = new RoleMenuExtend();
                r.setRoleId(roleId);
                r.setId(Long.parseLong(ri));
                r.setCreateTime(new Date());
                r.setUpdateTime(new Date());
                RoleMenuExtend.add(r);

            }
            if (RoleMenuExtend.size() == 0) {
                return;
            }
           // menuMapper.insertList(RoleMenuExtend);
        }
    }

    /**
     * 通过角色id批量删除
     *
     * @param roleId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void removeByRoleId(Long roleId) {
        //删除
//        Example example = new Example(SysRoleMenu.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("roleId", roleId);
//        menuMapper.deleteByExample(example);
    }
}