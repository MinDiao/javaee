package com.zw.zwshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.mapper.SysUserMapper;
import com.zw.zwshop.pojo.SysUser;
import com.zw.zwshop.service.SysUserService;
import com.zw.zwshop.utils.MD5Util; // 不删,方便后期MD5扩展
import com.zw.zwshop.utils.ToolUtil;
/**
 * 
 * @ClassName:  SysUserServiceImpl   
 * @Description: 管理员服务实现类 
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午4:44:43
 */

@Service
public class SysUserServiceImpl implements SysUserService {

	
	// 注入mapper
	@Autowired
	private SysUserMapper sysUserMapper;

	
	
	/**
	 * 添加管理员
	 */
	@Override
	public int add(SysUser user) throws RuntimeException {
		
		// 设置创建日期
		user.setCreateTime(ToolUtil.getCurrentTime());
		
		// 生成md5-32位密钥
		/*String pwd = MD5Util.md5Password(user.getPassword());
		user.setPassword(pwd);*/
		
		return sysUserMapper.insertSelective(user);
	}


	
	
	/**
	 * 用户列表
	 */
	@Override
	public PageInfo select(SysUserDto sysUserDto) {
		
		// 初始化分页插件
		PageHelper.startPage(sysUserDto.getPage(), sysUserDto.getLimit());
		
		// 查询
		List<SysUser> list = sysUserMapper.selectPage(sysUserDto);
		
		PageInfo<SysUser> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}




	/**
	 * 批量删除
	 */
	@Override
	public int delete(String[] ids) {
		
		return sysUserMapper.deleteBatch(ids);
	}




	/**
	 * 管理员登录
	 */
	@Override
	public SysUser login(SysUser sysUser) {
		
		// 通用mapper中根据对象查询只返回一条
		return sysUserMapper.selectOne(sysUser);
	}




	
	/**
	 * 验证管理员名是否存在
	 */
	@Override
	public SysUser selectName(SysUser sysUser) {
		
		return sysUserMapper.selectOne(sysUser);
	}
	

	
	
}









