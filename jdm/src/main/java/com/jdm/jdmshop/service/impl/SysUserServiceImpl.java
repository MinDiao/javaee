package com.jdm.jdmshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.jdmshop.mapper.SysUserMapper;
import com.jdm.jdmshop.pojo.SysUser;
import com.jdm.jdmshop.service.SysUserService;

/**
 * 
 * @ClassName:  SysUserServiceImpl   
 * @Description: 管理员服务层实现类
 * @author: LiuJinrong
 * @date:   2019年1月25日 上午10:32:27
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	
	/**
	 * 注入Mapper
	 */
	@Autowired
	private SysUserMapper sysUserMapper;

	
	
	/**
	 * 管理员登录
	 */
	@Override
	public SysUser login(SysUser sysUser) {
		
		// 管理员登录, 调用通用mapper的查询单个记录
		return sysUserMapper.selectOne(sysUser);
	}

}
