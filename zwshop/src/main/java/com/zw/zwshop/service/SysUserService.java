package com.zw.zwshop.service;

import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.pojo.SysUser;

/**
 * 
 * @ClassName:  SysUserService   
 * @Description: 管理员服务接口
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午4:43:55
 */
public interface SysUserService {

	
	/**
	 * 
	 * @Description: 添加管理员
	 * @author: LiuJinrong
	 * @date:   2019年1月5日 下午4:55:21    
	 * @param user
	 * @return
	 */
	int add(SysUser user) throws RuntimeException;
	
	
	
	/**
	 * 
	 * @Description: 用户列表
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 上午10:33:44    
	 * @param sysUserDto
	 * @return
	 */
	PageInfo select(SysUserDto sysUserDto);


	

	/**
	 * 
	 * @Description: 批量删除
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 下午2:20:20    
	 * @param ids id字符串数组
	 * @return 
	 */
	int delete(String[] ids);



	
	
	/**
	 * 
	 * @Description: 管理员登录
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 下午3:11:22    
	 * @param sysUser
	 * @return
	 */
	public SysUser login(SysUser sysUser);



	
	
	/**
	 * 
	 * @Description: 验证管理员名是否存在
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午10:04:14    
	 * @param username
	 */
	SysUser selectName(SysUser sysUser);


}









