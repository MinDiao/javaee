package com.tz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.tz.entiy.Customer;

/**
 * hibernate操作api增删改查
 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * 增
	 */
	@Test
	public void demo01(){
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.创建Session对象,类似Connection
		Session session = sessionFactory.openSession();
		
		// 4.开启事务
		Transaction tx = session.beginTransaction();
		
		// 5.执行相关操作
		Customer customer = new Customer();
		customer.setCust_name("恒哥");
		
		session.save(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 查
	 */
	@Test
	public void demo02(){
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.创建Session对象,类似Connection
		Session session = sessionFactory.openSession();
		
		// 4.开启事务
		Transaction tx = session.beginTransaction();
		
		// 5.执行相关操作
		Customer customer = session.get(Customer.class, 1l);
		
		System.out.println(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 改
	 */
	@Test
	public void demo3(){
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.创建Session对象,类似Connection
		Session session = sessionFactory.openSession();
		
		// 4.开启事务
		Transaction tx = session.beginTransaction();
		
		// 5.执行相关操作
		// 		1)获得需要修改对象
		Customer customer = session.get(Customer.class, 2l);
		// 		2)修改
		customer.setCust_name("绪绪");
		// 3)更新
		session.update(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 删除
	 */
	@Test
	public void demo4(){
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// 3.创建Session对象,类似Connection
		Session session = sessionFactory.openSession();
		
		// 4.开启事务
		Transaction tx = session.beginTransaction();
		
		// 5.执行相关操作
		// 		1)获得需要修改对象
		Customer customer = session.get(Customer.class, 2l);
		
		// 		2)调用delete删除对象
		session.delete(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.释放资源
		session.close();
		sessionFactory.close();
	}
}
