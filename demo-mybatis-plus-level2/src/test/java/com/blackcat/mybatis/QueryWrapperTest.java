package com.blackcat.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blackcat.mybatis.entity.SysMenu;
import com.blackcat.mybatis.entity.SysUser;
import com.blackcat.mybatis.mapper.SysMenuMapper;
import com.blackcat.mybatis.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> 描述 ：QueryWrapper查询示例
 * 基于mybatis 3.3.0
 * 只是代码示写法例
 * @author : blackcat
 * @date : 2020/2/1 10:56
 */
@SpringBootTest
public class QueryWrapperTest {

    @Resource
    private SysUserService iSysUserService;
    @Resource
    private SysMenuMapper menuMapper;

    /**
     * <p> 描述 : PageHelper分页插件
     * @author : blackcat
     * @date  : 2020/2/1 11:00
     */
    @Test
    public void page(){
        PageHelper.startPage(1, 3);
        List<SysMenu> list = menuMapper.findPageBreakByCondition(null); // 分页查询
        PageInfo<SysMenu> bean = new PageInfo<>(list);
        bean.setList(list);
    }

    /**
     * <p> 描述 : QueryWrapper分页
     * @author : blackcat
     * @date  : 2020/2/1 10:58
    */
    @Test
    public void page1(){
        Page<SysUser> page = new Page<>(1, 3);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(SysUser::getNickname,"111")
                .like(SysUser::getMobile,"11")
                .orderByDesc(SysUser::getCreateTime);
        iSysUserService.page(page, queryWrapper);
    }

    /**
     * <p> 描述 :
     * @author : blackcat
     * @date  : 2020/2/1 11:24
     */
    /*@Test
    public void page2() {
        Page<SysUser> page = new Page<>(1, 5);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "111");
        IPage<Map<String, Object>> mapIPage = (IPage<Map<String, Object>>) iSysUserService.pageMaps(queryWrapper);
        System.out.println(mapIPage);
    }*/

    /**
     * <p> 描述 : 返回的是一条实体记录，当出现多条时会报错
     * @author : blackcat
     * @date  : 2020/2/1 11:02
    */
    @Test
    public void selectOne() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");
        iSysUserService.getOne(queryWrapper);
    }

    /**
     * <p> 描述 : 根据 Wrapper 条件，查询总记录数
     * @author : blackcat
     * @date  : 2020/2/1 11:06
    */
    @Test
    public void selectCount() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");
        iSysUserService.count(queryWrapper);
    }


    /**
     * <p> 描述 : 查询全部记录
     * @author : blackcat
     * @date  : 2020/2/1 11:08
     * queryWrapper 实体对象封装操作类（可以为 null）为null查询全部
    */
    @Test
    public void selectList() {
        List<SysUser> list = iSysUserService.list();
    }

    /**
     * <p> 描述 : 根据 Wrapper 条件查询记录
     * @author : blackcat
     * @date  : 2020/2/1 11:21
     * queryWrapper 实体对象封装操作类（可以为 null）
     * 返回 List<Map<String, Object>> 类型数据
    */
    @Test
    public void selectMaps() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name");
        //iSysUserService.listMaps(QueryWrapper);
//        List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
//        for (Map<String, Object> map : maps) {
//            System.out.println(map);
//        }
    }

}
