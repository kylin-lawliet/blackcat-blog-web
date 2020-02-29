package com.blackcat.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackcat.blog.core.entity.SysOptions;

import java.util.List;
import java.util.Map;


/**
 * <p> 描述 : 系统参数
 * @author : blackcat
 * @date  : 2020/2/29 14:35
*/
public interface SysOptionsService  extends IService<SysOptions> {
	/**
	 * <p> 描述 : 查询所有配置
	 * @author : blackcat
	 * @date  : 2020/2/29 14:35
	*/
	List<SysOptions> findAll();


	/**
	 * <p> 描述 : 添加或修改配置
	 * - - - 修改时根据key判断唯一性
	 * @author : blackcat
	 * @date  : 2020/2/29 14:35
	 * @param options 参数键值对
	*/
	void update(Map<String, String> options);

	/**
	 * <p> 描述 : 执行SQL文件 导入数据
	 * @author : blackcat
	 * @date  : 2020/2/29 14:36
	 * @param resource 数据SQL文件
	 */
//	void initSettings(Resource resource);
}
