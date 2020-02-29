package com.blackcat.blog.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.github.pagehelper.PageInfo;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> ：接口返回工具类
 * @author : blackcat
 * @date : 2020/1/18 15:05
 */
public class ResultUtil extends HashMap<String, Object> {
    /**
     * 程序默认的成功状态码
     */
    private static final int DEFAULT_SUCCESS_CODE = 200;
    /**
     * 程序默认的错误状态码
     */
    private static final int DEFAULT_ERROR_CODE = 500;

    private ResultUtil() {
        put("code", DEFAULT_SUCCESS_CODE);
    }

    public static ResultUtil error() {
        return error(DEFAULT_ERROR_CODE, "未知异常，请联系管理员");
    }

    public static ResultUtil error(String msg) {
        return error(DEFAULT_ERROR_CODE, msg);
    }

    public static ResultUtil error(int code, String msg) {
        ResultUtil result = new ResultUtil();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static ResultUtil ok(String msg) {
        ResultUtil result = new ResultUtil();
        result.put("msg", msg);
        return result;
    }

    public static ResultUtil ok(Map<String, Object> map) {
        ResultUtil result = new ResultUtil();
        result.putAll(map);
        return result;
    }

    public static ResultUtil ok(ResponseStatusEnum success) {
        ResultUtil result = new ResultUtil();
        result.put("code", success.getCode());
        result.put("msg", success.getMessage());
        return result;
    }

    public static ResultUtil ok() {
        return new ResultUtil();
    }

    public static PageResult tablePage(Long total, List<?> list) {
        return new PageResult(total, list);
    }

    public static PageResult tablePage(PageInfo info) {
        if (info == null) {
            return new PageResult(0L, new ArrayList());
        }
        return tablePage(info.getTotal(), info.getList());
    }

    public static PageResult tablePage(Page info) {
        if (info == null) {
            return new PageResult(0L, new ArrayList());
        }
        return tablePage(info.getTotal(), info.getRecords());
    }

    public static ModelAndView redirect(String view) {
        return new ModelAndView("redirect:" + view);
    }

    @Override
    public ResultUtil put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
