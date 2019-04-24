package cn.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bean.User;

/**
 * 
 * 类描述：测试类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class AOPTest {
	
	/**
	 * 
	 * 方法描述:没有配置通知类
	 */
	@Test
	public void test1(){
		
		User user = new User();
		user.login();
	}
	
	/**
	 * 
	 * 方法描述:成功配置通知类
	 */
	@Test
	public void test2(){
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取user
		User bean = (User) app.getBean("user");
		// 执行
		bean.login();
	}
	
	/**
	 * 
	 * 方法描述:成功配置通知类-方法重载
	 */
	@Test
	public void test3(){
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取user
		User bean = (User) app.getBean("user");
		// 执行
		bean.login("jack");
	}

}














