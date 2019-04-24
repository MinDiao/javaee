package com.zw.service;

import com.zw.pojo.User;

/**
 * 
 * 接口描述：业务逻辑层接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserService {
	
	/**
	 * 
	 * 方法描述: 根据用户id查询用户id
	 * @param id
	 * @return
	 */
	public User selectById(int id);

	/**
	 * 
	 * 方法描述: 转账
	 * @param in
	 * @param out
	 * @param money
	 */
	public void tranfer(String in, String out, double money) throws RuntimeException;

}
