package com.blackcat.blog.core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> : SQL查询条件公共属性
 * @author : blackcat
 * @date : 2020/1/18 14:52
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseConditionVO {
    public final static int DEFAULT_PAGE_SIZE = 10;
    private int pageNumber = 1;
    private int pageSize = 0;
    private int pageStart = 0;
    private String sortName;
    private String sortOrder;
    private String keywords;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date startDate;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date endDate;

//    private SysUser user;

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

}
