package com.blackcat.blog.common.base;

import com.blackcat.blog.util.StringEscapeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * <p> ：
 *
 * @author : blackcat
 * @date : 2020/1/20 21:54
 */
public class BaseController {
    public BaseController() {
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //转义特殊字符，防止XSS攻击
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
        //处理spring-mvc对集合数据参数的长度限制（默认256）
        try{
            binder.setAutoGrowNestedPaths(true);
        }catch (Exception e){

        }
        //binder.setAutoGrowCollectionLimit(1024);
    }
}
