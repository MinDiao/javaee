package com.user.userutil;

import com.zw.pojo.User;

/**
 * 
 * 类描述：用户实体类工具类,单例模式
 * 作者： LiuJinrong  
 * 创建日期：2018年12月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserUtil {
	
	private static User user = null;
	
	static{
		user = new User();
	}
	
	public static User getUser(){
		return user;
	}

}
