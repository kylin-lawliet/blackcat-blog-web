package com.blackcat.blog.util;

import com.alibaba.fastjson.JSONObject;
import com.blackcat.blog.core.object.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> ：分页查询结果转换
 * @author : blackcat
 * @date : 2020/1/18 15:05
 */
public class ResultUtil {

    public static PageResult tablePage(Long total, List<?> list) {
        return new PageResult(total, list);
    }

    public static PageResult tablePage(PageInfo info) {
        if (info == null) {
            return new PageResult(0L, new ArrayList());
        }
        return tablePage(info.getTotal(), info.getList());
    }

    /*public static JSONObject tablePage(Long total, List<?> list){
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("total",total);
        jsonResult.put("rows",list);
        return jsonResult;
    }

    public static JSONObject tablePage(PageInfo info){
        if (info == null) {
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("total",0L);
            jsonResult.put("rows",new ArrayList());
            return jsonResult;
        }
        return tablePage(info.getTotal(), info.getList());
    }*/

}
