package com.blackcat.blog.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * <p> 描述 ：用户类型枚举
 *
 * @author : blackcat
 * @date : 2020/3/6 15:07
 */
@Getter
public enum UserTypeEnum{
    USER("user","通用户"),
    ROOT("root","超级管理员"),
    ADMIN("admin","管理员");

    UserTypeEnum(String code, String descp){
        this.code = code;
        this.descp = descp;
    }

    @EnumValue // 标记数据库存的值是name
    private String code;
    private String descp;
}
