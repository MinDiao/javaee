package com.zw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zw.dao.UserDao;
import com.zw.pojo.User;
import com.zw.util.JdbcUtils;
import com.zw.util.Page;
import com.zw.util.StringUtil;

public class UserDaoImpl implements UserDao{

	/**
	 * 查询+分页
	 */
	@Override
	public List<User> selectUsers(User user, Page page) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from t_user where 1=1 ");
		List<Object> paramList = new ArrayList<>();
		
		if(StringUtil.isNotEmpty(user.getUsername())){
			sql.append(" and username like ? ");
			paramList.add("%"+user.getUsername()+"%");
		}
		if(StringUtil.isNotEmpty(user.getSex())){
			sql.append(" and sex = ? ");
			paramList.add(user.getSex());
		}
		if (StringUtil.isNotEmpty(user.getBirthday())) {
			sql.append(" and birthday = ? ");
			paramList.add(user.getBirthday());
		}

		// 分页
		if (page.getPageNum() != 0) {
			// 分页的sql
			sql.append(" limit ?,? ");
			// 设置起始页(用到小算法)
			int start = (page.getPageNum() - 1) * page.getPageSize();
			paramList.add(start);
			// 设置每页显示的记录数
			paramList.add(page.getPageSize());
		}

		//将List转化为数组
		Object[] params = paramList.toArray();
		List<User> users=null;
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		try {
			users=queryRunner.query(sql.toString(), new BeanListHandler<>(User.class), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 分页页数的统计
	 */
	@Override
	public long selectCount(User user) {

		// sql
		StringBuffer sql=new StringBuffer();
		// 为了防止and的情况
		sql.append(" select count(*) from t_user where 1 = 1 ");
		List<Object> paramList = new ArrayList<>();
		// 用户姓名
		if(StringUtil.isNotEmpty(user.getUsername())){
			sql.append(" and username like ? ");
			paramList.add("%"+user.getUsername()+"%");
		}
		// 用户性别
		if(StringUtil.isNotEmpty(user.getSex())){
			sql.append(" and sex = ? ");
			paramList.add(user.getSex());
		}
		// 用户生日
		if (StringUtil.isNotEmpty(user.getBirthday())) {
			sql.append(" and birthday = ? ");
			paramList.add(user.getBirthday());
		}

		//将List转化为数组
		Object[] params = paramList.toArray();
		Long rows = null;
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			rows = queryRunner.query(sql.toString(), new ScalarHandler<Long>(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
