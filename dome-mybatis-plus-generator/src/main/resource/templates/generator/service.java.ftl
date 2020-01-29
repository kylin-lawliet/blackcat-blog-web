package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import java.util.List;

/**
 * <p> ${table.comment!} 服务类
 * @author ${author}
 * @data ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

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
