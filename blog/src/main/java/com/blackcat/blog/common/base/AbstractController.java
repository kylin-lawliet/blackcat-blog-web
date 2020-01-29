package com.blackcat.blog.common.base;

import com.blackcat.blog.core.enums.ResponseStatusEnum;
import com.blackcat.blog.core.object.PageResult;
import com.blackcat.blog.core.vo.*;
import com.blackcat.blog.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p> ：通用的controller实现
 * @author : blackcat
 * @date : 2020/1/20 21:57
 */
public abstract class AbstractController<T,BaseConditionVO> extends BaseController{

    /**
     * <p> : controller所属模块名称
     * @author : blackcat
     * @date : 2020/1/20 22:11
    */
    protected abstract String getName();

    /**
     * <p> : 获取service实现类
     * @author : blackcat
     * @date : 2020/1/20 22:00
     * @return AbstractService实现类
    */
    protected abstract AbstractService<T, BaseConditionVO> getService();

    /**
     * <p> : 获取权限管理页面数据
     * @author : blackcat
     * @date : 2020/1/20 16:46
     */
    //@RequestMapping("/list")
    @PostMapping("/list")
    public PageResult getAll(BaseConditionVO vo)  throws Exception{
        PageInfo<T> pageInfo = getService().findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    //@RequiresPermissions("resource:add")
    @PostMapping(value = "/add")
    public ResponseVO add(T entity)  throws Exception{
        getService().insert(entity);
        //更新权限
        //shiroService.updatePermission();
        return ResultUtil.success("成功");
    }

    //@RequiresPermissions(value = {"resource:batchDelete", "resource:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids)  throws Exception{
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        getService().deleteBatchIds(ids);
        //更新权限
        //shiroService.updatePermission();
        return ResultUtil.success("成功删除 [" + ids.length + "] 个"+getName());
    }

    //@RequiresPermissions("resource:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id)  throws Exception{
        return ResultUtil.success(null, this.getService().getByPrimaryKey(id));
    }

    //@RequiresPermissions("resource:edit")
    @PostMapping("/edit")
    public ResponseVO edit(T entity)  throws Exception{
        try {
            getService().updateById(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(getName()+"修改失败！");
        }
        return ResultUtil.success(ResponseStatusEnum.SUCCESS);
    }

}
