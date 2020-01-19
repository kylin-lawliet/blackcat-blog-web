package com.blackcat.blog.core.enums;

import org.springframework.util.StringUtils;

/**
 * <p> ：用户类型枚举
 * @author : blackcat
 * @date : 2020/1/18 14:36
 */
public enum UserTypeEnum {
    /**
     * <p> : 超级管理员
     * @author : blackcat
     * @date : 2020/1/18 14:37
    */
    ROOT("超级管理员"),
    /**
     * <p> : 管理员
     * @author : blackcat
     * @date : 2020/1/18 14:37
     */
    ADMIN("管理员"),
    /**
     * <p> : 系统会员
     * @author : blackcat
     * @date : 2020/1/18 14:37
     */
    USER("系统会员"),
    /**
     * <p> : 未知
     * @author : blackcat
     * @date : 2020/1/18 14:37
     */
    UNKNOW("未知");
    private String desc;

    UserTypeEnum(String desc) {
        this.desc = desc;
    }

    public static UserTypeEnum getByType(String type) {
        if (StringUtils.isEmpty(type)) {
            return UserTypeEnum.UNKNOW;
        }
        for (UserTypeEnum ut : UserTypeEnum.values()) {
            if (ut.toString().equalsIgnoreCase(type)) {
                return ut;
            }
        }
        return UserTypeEnum.UNKNOW;
    }

    public String getDesc() {
        return desc;
    }
}
