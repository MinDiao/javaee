package com.zw.mapper;

import com.zw.pojo.User;

/**
 * 
 * 接口描述：mapper映射接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserMapper {
	
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
	 * @param username
	 * @param money
	 * @return
	 */
	public int updateAccount(String username, double money);

}
