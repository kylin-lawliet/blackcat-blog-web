package com.blackcat.blog.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackcat.blog.core.entity.SysRole;
import com.blackcat.blog.core.vo.RoleConditionVO;

import java.util.List;

/**
 * <p> 角色Mapper
 * @author : blackcat
 * @date : 2020/1/16 20:09
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<SysRole> findPageBreakByCondition(RoleConditionVO vo);

    /**
     * 该节代码参考自http://blog.csdn.net/poorcoder_/article/details/71374002
     * 感谢网友
     *
     * @param userId
     * @return
     */
    List<SysRole> queryRoleListWithSelected(Integer userId);

    List<SysRole> listRolesByUserId(Long userId);
	
}
