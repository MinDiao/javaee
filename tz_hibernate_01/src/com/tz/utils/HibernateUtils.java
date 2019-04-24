package com.tz.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	static{
		
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		sessionFactory = cfg.buildSessionFactory();
	}
	
	// 获得session -> 全新的session
	public static Session openSession(){
		
		Session session = sessionFactory.openSession();
		return session;
	}
	
	// 获得session -> 线程绑定的session
	public static Session getCurrentSession(){
		
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
}
