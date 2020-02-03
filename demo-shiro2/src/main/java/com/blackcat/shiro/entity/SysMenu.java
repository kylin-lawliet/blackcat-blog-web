package com.blackcat.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author blackcat
 * @since 2020-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限类型（菜单，按钮）
     */
    private String type;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否外部链接
     */
    private Boolean external;

    /**
     * 是否可用
     */
    private Boolean available;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
