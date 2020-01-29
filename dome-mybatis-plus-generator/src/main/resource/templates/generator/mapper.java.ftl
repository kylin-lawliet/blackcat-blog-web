package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

/**
 * <p> ${table.comment!} Mapper 接口
 * @author ${author}
 * @data ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    /**
     * <p> : 分页查询
     * @author : blackcat
     * @date : ${date}
     * @param vo 条件封装
     * @return  List<SysMenu>
     */
     List<${entity}> findPageBreakByCondition(BaseConditionVO vo);
}
</#if>
