package com.blackcat.blog.util;

import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.vo.ResponseVO;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> ：接口返回工具类
 * @author : blackcat
 * @serialData : 2020/1/18 15:05
 */
public class ResultUtil {
    /**
     * 程序默认的成功状态码
     */
    public static final int DEFAULT_SUCCESS_CODE = 200;
    /**
     * 程序默认的错误状态码
     */
    public static final int DEFAULT_ERROR_CODE = 500;

    public static PageResult tablePage(Long total, List<?> list) {
        return new PageResult(total, list);
    }

    public static PageResult tablePage(PageInfo info) {
        if (info == null) {
            return new PageResult(0L, new ArrayList());
        }
        return tablePage(info.getTotal(), info.getList());
    }

    public static ResponseVO error(int code, String message) {
        return vo(code, message, null);
    }

    public static ResponseVO error(ResponseStatusEnum status) {
        return vo(status.getCode(), status.getMessage(), null);
    }

    public static ResponseVO error(String message) {
        return vo(DEFAULT_ERROR_CODE, message, null);
    }

    public static ResponseVO success(String message, Object data) {
        return vo(DEFAULT_SUCCESS_CODE, message, data);
    }

    public static ResponseVO success(String message) {
        return success(message, null);
    }

    public static ResponseVO success(ResponseStatusEnum status) {
        return vo(status.getCode(), status.getMessage(), null);
    }

    public static ResponseVO vo(int code, String message, Object data) {
        return new ResponseVO<>(code, message, data);
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
