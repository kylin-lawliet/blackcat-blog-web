package com.blackcat.blog.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 描述 ：首页分类查询结果集
 *
 * @author : blackcat
 * @date : 2020/3/6 12:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {

    /**
     * 分类id
     */
    private Long id;
    /**
     * 分类名称
    */
    private String name;
    /**
     * 分类数量
     */
    private Integer number;
}
