package com.blackcat.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p> ：主页
 * @author : blackcat
 * @date : 2020/1/18 15:19
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
