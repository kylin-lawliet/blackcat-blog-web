package com.blackcat.mybatis.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p> 描述 ：自定义分页属性
 * @author : blackcat
 * @date : 2020/1/26 23:01
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MyPage <T> extends Page<T> {
    private static final long serialVersionUID = 5194933845448697148L;

}
