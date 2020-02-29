package com.blackcat.blog.controller;

import com.blackcat.blog.common.config.ContextStartup;
import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.service.SysOptionsService;
import com.blackcat.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p> 描述 ：系统参数
 * @author : blackcat
 * @date : 2020/2/29 15:42
 */
@RestController
@RequestMapping("/admin/options")
public class SysOptionsController {
    @Autowired
    private SysOptionsService sysOptionsService;
    @Autowired
    private ContextStartup contextStartup;

    /**
     * <p> 描述 : 修改系统参数
     * @author : blackcat
     * @date  : 2020/2/29 15:54
    */
    @RequestMapping("/update")
    public ResultUtil update(@RequestParam Map<String, String> body) {
        sysOptionsService.update(body);
        contextStartup.reloadOptions(false);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 刷新系统变量
     * @return
     */
    @RequestMapping("/reload_options")
    public ResultUtil reloadOptions() {
        contextStartup.reloadOptions(false);
        return ResultUtil.ok(ResponseStatusEnum.SUCCESS);
    }
}
