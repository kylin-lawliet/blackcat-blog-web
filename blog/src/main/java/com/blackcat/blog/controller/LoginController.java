package com.blackcat.blog.controller;

import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <p> 描述 : 登陆相关
 * @author : blackcat
 * @date  : 2020/2/1 20:00
*/
@Slf4j
@Controller
public class LoginController {


    /**
     * <p> 描述 : 跳转登陆页面
     * @author : blackcat
     * @date  : 2020/2/1 20:01
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();
        if (user == null){
            return "login";
        }else{
            return "redirect:index";
        }
    }

    /**
     * <p> 描述 : 用户登录
     * @author : blackcat
     * @date  : 2020/2/3 17:04
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil loginUser(String username, String password, boolean rememberMe) {
        // 如果有点击  记住我
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            Subject subject = SecurityUtils.getSubject();
            SysUser user=(SysUser) subject.getPrincipal();
            SecurityUtils.getSubject().getSession(true).setAttribute("userInfo", user);
            return ResultUtil.ok("登录成功！");
        } catch (Exception e) {
            log.error("登录失败，用户名[{}]", username, e);
            token.clear();
            return ResultUtil.error(e.getMessage());
        }
    }

    /**
     * <p> 描述 : 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
     * @author : blackcat
     * @date  : 2020/2/1 20:13
    */
    @GetMapping("/logout")
    public ModelAndView logout(RedirectAttributes redirectAttributes) {
        // 退出操作是由Shiro控制的 不需要自己实现
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return ResultUtil.redirect("index");
    }
}
