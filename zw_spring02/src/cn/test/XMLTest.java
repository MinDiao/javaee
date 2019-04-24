package cn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.controller.UserController;

/**
 * 
 * 类描述：通过xml测试类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class XMLTest {

	@Test
	public void test(){
		
		// 1.加载spring的环境
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.获取bean
		UserController userController = (UserController) app.getBean("userController");
		
		// 3.方法调用
		userController.addUser();
	}
}
