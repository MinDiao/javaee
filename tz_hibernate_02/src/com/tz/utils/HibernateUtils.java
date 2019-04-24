package com.tz.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 类描述：Hibernate工具类
 * 作者： LiuJinrong
 * 创建日期：2018年12月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	static {
		// 1.加载核心配置文件
		Configuration cfg = new Configuration().configure();
		
		// 2.创建一个sessionFactory工厂
		sessionFactory = cfg.buildSessionFactory();
	}
	
	/**
	 * 
	 * 方法描述: 获得全新的Session
	 * @return
	 */
	public static Session openSession(){
		
		Session session = sessionFactory.openSession();
		return session;
	}
	
	/**
	 * 
	 * 方法描述: 获得与线程绑定的Session用户事务
	 * @return
	 */
	public static Session getCurrentSession(){
		
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
}
