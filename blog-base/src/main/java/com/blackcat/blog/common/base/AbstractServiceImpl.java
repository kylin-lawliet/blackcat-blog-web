package com.blackcat.blog.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.common.CommonMethod;
import com.blackcat.blog.core.entity.SysMenu;
import com.blackcat.blog.core.extend.BaseExtend;
import com.blackcat.blog.core.extend.MenuExtend;
import com.blackcat.blog.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.*;
import java.util.*;

/**
 * <p> ：通用的ServiceImpl
 * @author : blackcat
 * @date : 2020/1/20 22:15
 */
public class AbstractServiceImpl<T,BaseConditionVO,Entity,M extends BaseIMapper<Entity,BaseConditionVO>> implements AbstractService<T,BaseConditionVO>{

    @Autowired(required = false)
    protected M baseMapper;

    private Class<? extends BaseExtend> entityClazz;

    public AbstractServiceImpl() {
        //获取泛型指定的数据类型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            entityClazz= (Class) types[0];
        }else{
            throw new RuntimeException("继承AbstractService时 必须指定泛型内容");
        }
    }

    @Override
    public PageInfo<T> findPageBreakByCondition(BaseConditionVO baseConditionVO) throws Exception {

        Integer pageNumber = (Integer) BeanUtil.getGetMethodValue(baseConditionVO, "pageNumber");
        Integer pageSize = (Integer) BeanUtil.getGetMethodValue(baseConditionVO, "pageSize");
        System.out.println("pageNumber"+pageNumber);
        System.out.println("pageSize"+pageSize);
//        Class<?> cls = baseConditionVO.getClass();
//        Method getPageNumber = cls.getMethod("getPageNumber", new Class[] {});
//        Method getPageSize = cls.getMethod("getPageSize", new Class[] {});
//        Integer pageNumber = (Integer) getPageNumber.invoke(baseConditionVO,new Object[] {});
//        Integer pageSize = (Integer) getPageSize.invoke(baseConditionVO,new Object[] {});

        /*PropertyDescriptor pd = new PropertyDescriptor("pageNumber", entityClazz);
        Method regionReaad = pd.getReadMethod();
        Integer pageNumber= (Integer) regionReaad.invoke(baseConditionVO);

        PropertyDescriptor pd2 = new PropertyDescriptor("pageSize", entityClazz);
        Method regionReaad2 = pd2.getReadMethod();
        Integer pageSize= (Integer) regionReaad2.invoke(baseConditionVO);
*/
        PageHelper.startPage(pageNumber, pageSize);

        List<Entity> pageBreakByCondition = (List<Entity>) baseMapper.findPageBreakByCondition(baseConditionVO);
        List<T> list = getResources(pageBreakByCondition);
        PageInfo bean = new PageInfo<>(pageBreakByCondition);
        bean.setList(list);

        return bean;
    }

    @Override
    public boolean insert(T entity)  throws Exception{
        Assert.notNull(entity, "insert(entity)不可为空！");
        BeanUtil.putAttr(entity,"createTime",new Date());
        BeanUtil.putAttr(entity,"updateTime",new Date());
        return CommonMethod.retBool(baseMapper.insert((Entity) entity));
    }

    @Override
    public boolean updateById(T entity)  throws Exception{
        Assert.notNull(entity, "updateById(entity)不可为空！");
        BeanUtil.putAttr(entity,"updateTime",new Date());
        return CommonMethod.retBool(baseMapper.updateById((Entity) entity));
    }

    @Override
    public void deleteBatchIds(Long[] ids)  throws Exception{
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public T getByPrimaryKey(Long primaryKey)  throws Exception{
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        Entity entity = baseMapper.selectById(primaryKey);
        if (null == entity) {
            return null;
        } else {
            Constructor cons1 = entityClazz.getConstructor(entity.getClass());
            cons1.newInstance(entity.getClass());
            return (T) entityClazz;
        }
        //return null == entity ? null : new T(entity);
        //return null;
    }
    /**
     * <p> : 将系统权限类转为扩展类
     * @author : blackcat
     * @date : 2020/1/17 14:27
     * @Param List<SysMenu>
     * @return List<MenuExtend> 集合
     */
    protected List<MenuExtend> getResources(List<SysMenu> sysMenus) {
        if (CollectionUtils.isEmpty(sysMenus)) {
            return null;
        }
        List<MenuExtend> resources = new ArrayList<>();
        for (SysMenu menu : sysMenus) {
            resources.add(new MenuExtend(menu));
        }
        return resources;
    }
    /**
     * <p> : 将系统类转为扩展类
     * @author : blackcat
     * @date : 2020/1/17 14:27
     */
    private List<T> getResources(List<Entity> entitys) throws Exception {
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<T> resources = new ArrayList<>();
        for (Entity entity : entitys) {

            //entityClazz.getTInstance();
            //Constructor cons1 = entityClazz.getConstructor(entity.getClass());
//            cons1.newInstance(entity.getClass());
//            resources.add((T) entityClazz);
        }
        return resources;
    }

}
