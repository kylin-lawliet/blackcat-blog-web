package com.blackcat.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackcat.blog.common.constant.RedisKey;
import com.blackcat.blog.core.entity.BlogArticle;
import com.blackcat.blog.core.entity.BlogCodeList;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.BlogArticleService;
import com.blackcat.blog.core.service.BlogCodeListService;
import com.blackcat.blog.core.service.BlogMessageService;
import com.blackcat.blog.core.vo.ArticleVo;
import com.blackcat.blog.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> ：页面跳转类
 * @author : blackcat
 * @date : 2020/1/20 19:11
 */
@Controller
public class PageController {

    @Resource
    private BlogCodeListService iBlogListCodeService;
    @Resource
    private BlogArticleService iBlogArticleService;
    @Resource
    private BlogMessageService blogMessageService;
    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/comment/index")
    public String comment() {
        return "blog/comment";
    }

    /**
     * <p> 描述 : 跳转消息通知管理
     * @author : blackcat
     * @date  : 2020/3/14 15:11
    */
    @GetMapping("/message/index")
    public String message() {
        return "blog/message";
    }

    //******************************博客文章 start**************************************
    /**
     * <p> : 跳转文章管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/article/index")
    public String article() {
        return "blog/article";
    }

    /**
     * <p> : 跳转文章编辑页面页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/article/detail/{id}")
    public String newArticle(@PathVariable Long id,ModelMap map) {
        if(id!=0){
            if (redisUtil.hasKey(RedisKey.ARTICLE_INFO + id + RedisKey.FALSE)) {
                map.put("articleVo", redisUtil.get(RedisKey.ARTICLE_INFO + id + RedisKey.FALSE, ArticleVo.class));
            } else {
                map.put("articleVo", iBlogArticleService.getArticleById(id, false));
            }
        }
        return "blog/article_detail";
    }

    /**
     * <p> 描述 : 博客文章前台信息
     * @author : blackcat
     * @date  : 2020/3/3 15:46
    */
    @GetMapping("/article/view/{id}")
    public String view(@PathVariable Long id,ModelMap map) {
        if(id!=0){
            ArticleVo articleVo;
            if (redisUtil.hasKey(RedisKey.ARTICLE_INFO + id + RedisKey.TRUE)) {
                articleVo = redisUtil.get(RedisKey.ARTICLE_INFO + id + RedisKey.TRUE, ArticleVo.class);
            } else {
                articleVo = iBlogArticleService.getArticleById(id, true);
            }
            map.put("articleVo", articleVo);
            iBlogArticleService.updateArticleViewCount(id);
            blogMessageService.updateStatus(id);
            redisUtil.set(RedisKey.ARTICLE+id,articleVo.getArticle());
        }
        return "blog/article_view";
    }
    //******************************博客文章 end**************************************

    //******************************码表 start**************************************
    /**
     * <p> : 跳转总码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/code/listIndex")
    public String codeList() {
        return "blog/code_list";
    }

    /**
     * <p> : 跳转子码表管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/code/index/{id}")
    public String code(@PathVariable Long id, ModelMap map) {
        if(redisUtil.hasKey(RedisKey.CODE_LIST+id)){
            BlogCodeList codeList = redisUtil.get(RedisKey.CODE_LIST + id, BlogCodeList.class);
            map.addAttribute("codeParent", codeList);
        }else{
            map.addAttribute("codeParent", iBlogListCodeService.getById(id));
        }
        return "blog/code";
    }
    //******************************码表 start**************************************



    //********************************系统管理相关****************************************

    /**
     * <p> : 跳转系统配置页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/system/options")
    public String options() {
        return "options/index";
    }

    /**
     * <p> 描述 : 访问项后台管理首页
     * @author : blackcat
     * @date  : 2020/2/3 17:02
     */
    @RequiresUser
    @GetMapping("/admin")
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();
        if (user == null){
            return "login";
        }else{
            return "admin";
        }
    }

    /**
     * <p> : 跳转前台首页
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @RequestMapping("/")
    public String web(ModelMap map) {
        List<BlogArticle> articles = iBlogArticleService.list(new QueryWrapper<BlogArticle>().lambda().eq(BlogArticle::getPublish,1));
        map.put("articles", articles);
        return "index";
    }

    /**
     * <p> : 跳转权限管理页面
     * @author : blackcat
     * @date : 2020/1/19 13:44
     */
    @GetMapping("/menu/index")
    public String resources() {
        return "system/menu";
    }

    /**
     * <p> : 跳转用户管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @GetMapping("/user/index")
    public String user() {
        return "system/user";
    }

    /**
     * <p> : 跳转角色管理列表页面
     * @author : blackcat
     * @date : 2020/1/19 13:46
     */
    @GetMapping("/role/index")
    public String role() {
        return "system/role";
    }

}
