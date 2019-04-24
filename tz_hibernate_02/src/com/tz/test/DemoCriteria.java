package com.tz.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.tz.entity.Customer;
import com.tz.utils.HibernateUtils;

/**
 * 
 * 类描述：Criteria对象
 * 作者： LiuJinrong  
 * 创建日期：2018年12月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class DemoCriteria {

	/**
	 * 
	 * 方法描述:Criteria对象查询所有
	 */
	@Test
	public void demo01(){
		
		// 1.获得新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建Criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		// 4.将查询结果填充到List数组中
		List<Customer> list = criteria.list();
		
		// 5.遍历List集合并将结果输出至控制台
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		// 6.提交
		tx.commit();
		
		// 7.关闭资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:设置参数 Criteria对象条件查询
	 */
	@Test
	public void demo02(){
		
		// 1.获得新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建Criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		// 4.设置参数
		criteria.add(Restrictions.eq("cust_name", "腾讯"));
		criteria.add(Restrictions.eq("cust_industry", "3"));
		
		// 5.执行查询并将结果填充至List集合
		List<Customer> list = criteria.list();
		
		// 6.遍历集合并将结果输出至控制台
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		// 7.提交事务
		tx.commit();
		
		// 8.释放资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:Criteria对象分页查询
	 */
	@Test
	public void demo03(){
		
		// 1.获得一个全新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建Criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		// 4.设置分页参数
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		
		// 5.将分页查询的结果填充到List集合中
		List<Customer> list = criteria.list();
		
		// 6.遍历List集合并输出至控制台
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}
		
		// 7.提交事务
		tx.commit();
		
		// 8.释放资源
		session.close();
	}
	
	/**
	 * 
	 * 方法描述:Criteria对象查询总记录数
	 */
	@Test
	public void demo04(){
		
		// 1.获得一个全新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建Criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		// 4.设置参数:查询总记录数
		/**
		 * 	加入查询条件
         *	总记录数
         *	criteria.setProjection(Projections.rowCount());
         *	平均
         *	criteria.setProjection(Projections.avg("age"));
         *	分组
         *	criteria.setProjection(Projections.groupProperty("username"));
		 */
		criteria.setProjection(Projections.rowCount());
		
		// 5.将查询的结果填充到List集合中
		List<Customer> list = criteria.list();
		// 将结果打印到控制台
		System.out.println(list);
		
		// 6.提交事务
		tx.commit();
		
		// 7.关闭资源
		session.close();
	}
	
	
	
	/** 
	 * Criteria对象条件查询
		 *
		 *  > 				gt
		 *  >=				ge
		 *  <				lt
		 *  <=				le
		 *  == 				eq
		 *  !=				ne
		 *  in 				in
		 *  between and		between
		 *  is not null		isNotNull 
		 *  is null			isNull
		 *  or 				or
		 *  and				and
		 * 
		 */
	@Test
	public void demo05(){
		
		// 1.获得一个全新的Session
		Session session = HibernateUtils.openSession();
		
		// 2.开启事务
		Transaction tx = session.beginTransaction();
		
		// 3.创建Criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		// 4.设置参数
		criteria.add(Restrictions.eqOrIsNull("cust_id", 1l));
		
		// 5.将查询的结果填充到List集合
		Customer customer = (Customer) criteria.uniqueResult();
		// 打印至控制台
		System.out.println(customer);
		
		// 6.提交事务
		tx.commit();
		
		// 7.关闭资源
		session.close();
	}
}
