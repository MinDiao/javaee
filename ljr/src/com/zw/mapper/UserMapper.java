package com.zw.mapper;

import java.util.List;

import com.zw.pojo.User;

/**
 * 
 * 接口描述：mapper映射接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月19日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserMapper {
	
	/**
	 * 
	 * 方法描述: 根据用户id删除单条用户信息
	 * @param userId
	 * @return
	 */
	int userDeleteById(int userId);
	
	
	/**
	 * 
	 * 方法描述: 根据用户id批量删除用户信息
	 * @param userIds
	 * @return
	 */
	int userDeleteByIds(String[] userIds);
	
	
	/**
	 * 
	 * 方法描述: 模糊查询
	 * @return
	 */
	List<User> userSelectByFuzzy(User user);
	
	
	/**
	 * 
	 * 方法描述: 修改用户
	 * @param user
	 * @return
	 */
	int userUpdate(User user);
	
	
	/**
	 * 
	 * 方法描述:添加用户
	 * @param user 用户实体类
	 * @return 影响行数
	 */
	int userAdd(User user);

}
