package cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.service.UserService;

/**
 * 
 * 类描述：用户控制层
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * 方法描述:添加用户
	 */
	public void addUser(){
		
		System.out.println("控制层,添加用户方法...");
		// 调用添加用户方法
		userService.addUser();
	}

}
