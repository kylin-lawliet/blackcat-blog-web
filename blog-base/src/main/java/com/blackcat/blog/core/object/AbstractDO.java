package com.blackcat.blog.core.object;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p> 公共属性
 * @author: blackcat
 * @date: 2020/1/16 14:30
*/
@Data
// 此注解会生成equals(Object other) 和 hashCode()方法。
// true : 那就是用自己的属性和从父类继承的属性 来生成hashcode
// false : 不调用父类的属性
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractDO implements Serializable {

    private static final long serialVersionUID = 5088697673359856350L;

    private Long id;

    private Date createTime;// 添加时间
    private Date updateTime;// 更新时间

}