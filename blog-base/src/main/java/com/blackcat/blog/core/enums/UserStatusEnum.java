package com.blackcat.blog.core.enums;

/**
 * <p> ：用户状态
 * @author : blackcat
 * @date : 2020/1/18 14:38
 */
public enum UserStatusEnum {
    /**
     * <p> : 正常
     * @author : blackcat
     * @date : 2020/1/18 14:38
    */
    NORMAL(1, "正常"),
    /**
     * <p> : 禁用
     * @author : blackcat
     * @date : 2020/1/18 14:38
     */
    DISABLE(0, "禁用");

    private Integer code;
    private String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserStatusEnum get(Integer code) {
        if (null == code) {
            return NORMAL;
        }
        UserStatusEnum[] enums = UserStatusEnum.values();
        for (UserStatusEnum anEnum : enums) {
            if (anEnum.getCode().equals(code)) {
                return anEnum;
            }
        }
        return NORMAL;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
