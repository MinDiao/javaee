package com.tz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.tz.entiy.Customer;

/**
 * hibernate入门api测试
 * @author Administrator
 *
 */
public class Demo01 {
	
	@Test
	public void demo01(){
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.创建Session对象,它类似Connection
		Session session = sessionFactory.openSession();
		
		// 4.开启事务
		Transaction beginTransaction = session.beginTransaction();
		
		// 5.执行相关操作
		Customer customer = new Customer();
		customer.setCust_name("刘导");
		
		session.save(customer);
		
		// 6.提交事务
		beginTransaction.commit();
		
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}
}
