package com.blackcat.blog.core.object;

import com.blackcat.blog.core.vo.BaseConditionVO;
import com.github.pagehelper.PageInfo;

/**
 * <p> ：通用的service层
 * @author : blackcat
 * @date : 2020/1/20 17:03
 */
public interface AbstractIService<T, PK>{

    /**
     * <p> : 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @author : blackcat
     * @date : 2020/1/20 17:04
    */
    boolean insert(T entity);

    /**
     * <p> : 根据主键更新属性不为null的值
     * @author : blackcat
     * @date : 2020/1/20 17:05
     */
    boolean updateById(T entity);

    /**
     * <p> : 批量删除
     * @author : blackcat
     * @date : 2020/1/20 21:46
     */
    void deleteBatchIds(Long[] ids);

    /**
     * <p> : 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @author : blackcat
     * @date : 2020/1/20 17:05
     */
    T getByPrimaryKey(PK primaryKey);

}
