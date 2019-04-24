package com.zw.pojo;

import java.util.List;

/**
 * 
 * 类描述：
 * 作者： LiuJinrong  
 * 创建日期：2018年12月18日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserVo extends User {
	
	private List<Car> cars;

	public UserVo() {
		
	}

	public UserVo(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "UserVo [cars=" + cars + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getBirthday()="
				+ getBirthday() + ", getSex()=" + getSex() + ", getAddress()=" + getAddress() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
