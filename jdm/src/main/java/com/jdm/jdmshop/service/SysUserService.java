package com.jdm.jdmshop.service;

import com.jdm.jdmshop.pojo.SysUser;

/**
 * 
 * @ClassName:  SysUserService   
 * @Description: 管理员服务层接口 
 * @author: LiuJinrong
 * @date:   2019年1月25日 上午10:31:26
 */
public interface SysUserService {

	
	/**
	 * 
	 * @Description: 管理员登录
	 * @author: LiuJinrong
	 * @date:   2019年1月25日 上午11:06:38    
	 * @param sysUser
	 * @return
	 */
	SysUser login(SysUser sysUser);

}
