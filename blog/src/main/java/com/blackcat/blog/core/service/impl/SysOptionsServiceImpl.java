package com.blackcat.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackcat.blog.core.entity.SysOptions;
import com.blackcat.blog.core.mapper.SysOptionsMapper;
import com.blackcat.blog.core.service.SysOptionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p> 描述 : 系统参数
 * @author : blackcat
 * @date  : 2020/2/29 14:56
*/
@Service
public class SysOptionsServiceImpl  extends ServiceImpl<SysOptionsMapper, SysOptions> implements SysOptionsService {

	@Resource
	private SysOptionsMapper optionsMapper;

	@Override
	@Transactional(readOnly = true)
	public List<SysOptions> findAll() {
		List<SysOptions> list = optionsMapper.selectList(null);
		List<SysOptions> rets = new ArrayList<>();
		for (SysOptions po : list) {
			SysOptions r = new SysOptions();
			BeanUtils.copyProperties(po, r);
			rets.add(r);
		}
		return rets;
	}

	@Override
	public void update(Map<String, String> options) {
		if (options == null) {
			return;
		}
		options.forEach((key, value) -> {
			QueryWrapper queryWrapper=new QueryWrapper<SysOptions>().eq("key_name",key);
			SysOptions entity = optionsMapper.selectOne(queryWrapper);
			String val = StringUtils.trim(value);
			if (entity != null) {
				entity.setValue(val);
				optionsMapper.update(entity,queryWrapper);
			} else {
				entity = new SysOptions();
				entity.setKeyName(key);
				entity.setValue(val);
				optionsMapper.insert(entity);
			}
		});
	}

//	@Override
//	public void initSettings(Resource resource) {
//		Session session = entityManager.unwrap(Session.class);
//		session.doWork(connection -> ScriptUtils.executeSqlScript(connection, resource));
//	}

}
