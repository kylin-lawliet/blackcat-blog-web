package com.blackcat.blog.core.enums;

/**
 * <p> ：权限类型
 * @author : blackcat
 * @serialData : 2020/1/17 14:23
 */
public enum MenuTypeEnum {

    /**
     * <p> : 菜单类型
     * @author : blackcat
     * @serialData : 2020/1/17 14:59
    */
    menu("菜单"),
    /**
     * <p> : 按钮类型
     * @author : blackcat
     * @serialData : 2020/1/17 14:59
     */
    button("按钮");

    private final String info;

    private MenuTypeEnum(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
