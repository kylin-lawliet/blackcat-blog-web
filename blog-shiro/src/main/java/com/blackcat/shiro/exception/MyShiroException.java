package com.blackcat.shiro.exception;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>  ： 自定义异常
 * @author : blackcat
 * @date : 2020/1/14 12:45
 */
@ControllerAdvice
public class MyShiroException {
    
    /**
     * 处理Shiro权限拦截异常
     * @author : blackcat
     * @date : 2020/1/14 12:44
     * @param []
     * @return Map<Object> 返回结果集
    */
    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public Map<String,Object> defaultErrorHandler(){
        Map<String,Object> map = new HashMap<>();
        map.put("403","权限不足");
        return map;
    }
}