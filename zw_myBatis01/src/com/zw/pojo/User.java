package com.zw.pojo;

import java.util.Date;

/**
 * 
 * 类描述：用户实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月17日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class User {
	// 用户id
	private int id;
	// 用户姓名
	private String username;
	// 用户生日
	private Date birthday;
	// 用户性别
	private String sex;
	// 用户地址
	private String address;

	public User() {
		
	}

	public User(String username, Date birthday, String sex, String address) {
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
}
