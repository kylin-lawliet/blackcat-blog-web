package com.blackcat.mybatis;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.mybatis.entity.SysRoleMenu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> 描述 ：UpdateWrapper示例
 * @author : blackcat
 * @date : 2020/2/1 10:41
 */
@SpringBootTest
public class UpdateWrapperTest {

    /**
     * <p> 描述 : 删除
     * @author : blackcat
     * @date  : 2020/2/1 10:46
     * updateWrapper 删除的查询条件
    */
    @Test
    public void delete() {
        String roleId = "1";
        String menuId="1,2,3";
        String[] resourcesArr = menuId.split(",");
        UpdateWrapper<SysRoleMenu> updateWrapper  = new UpdateWrapper<>();
        updateWrapper.eq("role_id", roleId);
        updateWrapper.in("menu_id",resourcesArr);
        //iSysRoleMenuService.remove(updateWrapper);
    }

    /**
     * <p> 描述 : 根据 whereEntity 条件，更新记录
     * @author : blackcat
     * @date  : 2020/2/1 10:50
     * entity 实体对象 (set 条件值,不能为 null)
     * updateWrapper 修改查询条件
    */
    @Test
    public void update() {
        //修改值
        SysRoleMenu menu = new SysRoleMenu();
        menu.setMenuId((long) 1);
        //修改条件
        UpdateWrapper<SysRoleMenu> menuUpdateWrapper = new UpdateWrapper<>();
        menuUpdateWrapper.eq("id", "1");
        //int update = iSysRoleMenuService.update(menu, menuUpdateWrapper);
        System.out.println(menu);
    }
}
