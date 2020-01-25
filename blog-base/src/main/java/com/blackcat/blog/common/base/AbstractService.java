package com.blackcat.blog.common.base;

import com.github.pagehelper.PageInfo;

/**
 * <p> ：通用的service层
 * @author : blackcat
 * @date : 2020/1/20 17:03
 */
public interface AbstractService<T,BaseConditionVO>{

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : 2020/1/19 13:32
     */
    PageInfo<T> findPageBreakByCondition(BaseConditionVO vo) throws Exception;

    /**
     * <p> : 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @author : blackcat
     * @date : 2020/1/20 17:04
    */
    boolean insert(T entity) throws Exception;

    /**
     * <p> : 根据主键更新属性不为null的值
     * @author : blackcat
     * @date : 2020/1/20 17:05
     */
    boolean updateById(T entity) throws Exception;

    /**
     * <p> : 批量删除
     * @author : blackcat
     * @date : 2020/1/20 21:46
     */
    void deleteBatchIds(Long[] ids) throws Exception;

    /**
     * <p> : 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @author : blackcat
     * @date : 2020/1/20 17:05
     */
    T getByPrimaryKey(Long id) throws Exception;

//    /**
//     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
//     *
//     * @param entity
//     * @return
//     */
//    T getOneByEntity(T entity);

}
