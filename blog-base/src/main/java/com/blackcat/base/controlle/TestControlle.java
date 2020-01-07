package com.blackcat.base.controlle;

import org.springframework.web.bind.annotation.*;

/**
 * @author: blackcat
 * @date: 2020/1/6 19:37
 */
@RestController//该注释返回json
@RequestMapping("test")
public class TestControlle {

    @RequestMapping
    public String test(){
        return "ok";
    }
}
