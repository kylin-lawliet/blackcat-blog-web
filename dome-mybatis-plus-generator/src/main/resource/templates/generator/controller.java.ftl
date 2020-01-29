package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;


import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${cfg.projectPath}.vo.BaseConditionVO;
import org.springframework.web.bind.annotation.RestController;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p> ${table.comment!} 前端控制器
 * @author ${author}
 * @date ${date}
 */
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} i${entity}Service;

    @RequestMapping("/list")
    public PageResult list(BaseConditionVO vo){
        PageInfo<SysMenu> pageInfo = i${entity}Service.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

     @PostMapping(value = "/add")
     public ResultUtil add(SysMenu menu) {
         i${entity}Service.save(menu);
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }

     @PostMapping(value = "/remove")
     public ResultUtil remove(Long[] ids) {
         if (null == ids) {
         return ResultUtil.error(String.valueOf(ResponseStatusEnum.REMOVE_ERROR));
         }
         i${entity}Service.deleteBatchIds(ids);
         return ResultUtil.ok("成功删除 [" + ids.length + "] 个数据");
     }

     @PostMapping("/get/{id}")
     public ResultUtil get(@PathVariable Long id) {
         return ResultUtil.ok().put("data",i${entity}Service.getById(id));
     }

     @PostMapping("/edit")
     public ResultUtil edit(SysMenu menu) {
         try {
             i${entity}Service.updateById(menu);
         } catch (Exception e) {
             e.printStackTrace();
             return ResultUtil.error(String.valueOf(ResponseStatusEnum.SAVE_ERROR));
         }
         return ResultUtil.ok(String.valueOf(ResponseStatusEnum.SUCCESS));
     }
}
</#if>
