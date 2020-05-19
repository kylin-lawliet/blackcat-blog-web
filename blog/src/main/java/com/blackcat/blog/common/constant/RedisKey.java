package com.blackcat.blog.common.constant;

/**
 * <p> 描述 ：RedisKey
 * @author : blackcat
 * @date : 2020/2/29 18:17
 */
public class RedisKey {

    /**
     * 真假判定：真
     */
    public static String TRUE="_1";
    /**
     * 真假判定：假
     */
    public static String FALSE="_0";

    /**
     * 总码表
     * key:code_list+BlogCodeList表id
     * value:BlogCodeList对象
     */
    public static String CODE_LIST="code_list_";

    /**
     * 总码表-对应子码表list
     * key:code_sublist_+BlogCodeList表id
     * value:BlogCode对象集合
     */
    public static String CODE_LIST_SUBLIST="code_sublist_";

    /**
     * 子码表_id
     * key:BlogCode表id
     * value:BlogCode对象
     */
    public static String CODE="code_";

    /**
     * 码表数据  递归获取所有子节点
     * key:根节点id
     * value:递归获取所有子节点
     */
    public static String CODE_ALL="code_all_";

    /**
     * 码表数据 获取所有节点json字符串
     * key:根节点id
     * value:获取所有节点json字符串
     */
    public static String CODE_ALL_JSON="code_all_Json_";

    /**
     * 消息数据管理
     * key:Message对象id
     * value:Message对象
     */
    public static String MESSAGE="message_";

    /**
     * 资源菜单
     * key:sys_menu对象id
     * value:sys_menu对象
     */
    public static String SYS_MENU="sys_menu_";

    /**
     * 权限管理
     * key:sys_role对象id
     * value:sys_role对象
     */
    public static String SYS_ROLE="sys_role_";

    /**
     * 用户
     * key:sys_role对象id
     * value:sys_role对象
     */
    public static String SYS_USER="sys_user_";

    /**
     *  热门文章
     */
    public static String ARTICLE_TOP= "article_top";

    /**
     *  首页分类
     */
    public static String MAIN_CATEGORY= "main_category";

    /**
     *  博客文章 数据库数据 后台管理使用
     */
    public static String ARTICLE= "article_";

    /**
     *  博客文章 前端整合数据
     */
    public static String ARTICLE_INFO= "article_info_";

    /**
     *  博客标签
     */
    public static String ARTICLE_TAG= "article_tag_";

    /**
     *  博客评论
     */
    public static String ARTICLE_COMMENT= "article_comment_";

}
