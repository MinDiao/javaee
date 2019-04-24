package com.zw.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.pojo.User;
import com.zw.service.UserService;

/**
 * 
 * 类描述：Spring整合MyBatis测试类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class SMTest {

	/**
	 * 
	 * 方法描述:根据用户id查询用户id
	 */
	@Test
	public void test(){
		// 1.加载spring的环境
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取bean
		UserService userService = app.getBean("userServiceImpl",UserService.class);
		// 3.方法调用
		User user = userService.selectById(1);
		System.err.println(user.toString());
	}

	/**
	 * 
	 * 方法描述:转账xml方式
	 */
	@Test
	public void test2(){
		// 1.加载spring的环境
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取bean
		UserService userService = app.getBean("userServiceImpl",UserService.class);
		// 3.方法调用
		String in = "rose"; // 转入账户
		String out = "jack"; // 转出账户
		double money = 100d; // 转账金额
		userService.tranfer(in,out,money);
	}
	
	
	/**
	 * 
	 * 方法描述:转账注解方式
	 */
	@Test
	public void test3(){
		// 1.加载spring的环境
		ApplicationContext app = new ClassPathXmlApplicationContext("com/zw/test/applicationContext.xml");
		// 2.获取bean
		UserService userService = app.getBean("userServiceImpl",UserService.class);
		// 3.方法调用
		String in = "rose"; // 转入账户
		String out = "jack"; // 转出账户
		double money = 100d; // 转账金额
		userService.tranfer(in,out,money);
	}
	
}
