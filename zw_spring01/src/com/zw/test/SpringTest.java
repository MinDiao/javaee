package com.zw.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.bean.Car;
import com.zw.bean.Person;
import com.zw.bean.User;

/**
 * 
 * 类描述：spring测试用例
 * 作者： LiuJinrong  
 * 创建日期：2018年12月21日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class SpringTest {

	@Test
	public void test(){
		Person p = new Person();
		p.run();
	}


	/**
	 * 
	 * 方法描述:获取spring中的springbean	person实例化对象
	 */
	@Test
	public void test2(){
		// 1.加载配置文件,并且实例化配置的类
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取spring容器给我们创建好的实例
		Person p = app.getBean("person", Person.class);
		// 3.输出调用
		p.run();
		// 输出com.zw.bean.Person@731a74c地址
		System.out.println(p);
	}


	/**
	 * 
	 * 方法描述:spring注入
	 */
	@Test
	public void test3(){
		// 1.加载配置文件,并且实例化配置的类
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取spring容器给我们创建好的实例
		User user = (User) app.getBean("user");
		// 3.输出调用
		System.out.println(user);
	}


	/**
	 * 
	 * 方法描述:类注入
	 */
	@Test
	public void test4(){
		// 1.加载配置文件,并且实例化配置的类
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取spring容器给我们创建好的实例
		User user = (User) app.getBean("user");
		// 3.输出调用
		System.out.println(user);
	}


	@Test
	public void test5(){
		// 1.加载配置文件,并且实例化配置的类
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.获取spring容器给我们创建好的实例
		Car car = (Car) app.getBean("car");
		Car car2 = (Car) app.getBean("car");
		// 3.输出调用
		System.out.println(car);
		System.out.println(car2);
	}
}














