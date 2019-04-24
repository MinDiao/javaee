package com.zw.zw_mvnljrssm.dto;

/**
 * 
 * 类描述：用户条件查询+分页
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class UserDto {

	// 用户名
	private String username;
	// 性别
	private String sex;
	// 范围查询起始生日
	private String birthdaybegin;
	// 范围查询结束生日
	private String birthdayend;
	
	// 页码
	private int pageNum;
	// 页容量
	private int pageSize;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthdaybegin() {
		return birthdaybegin;
	}
	public void setBirthdaybegin(String birthdaybegin) {
		this.birthdaybegin = birthdaybegin;
	}
	public String getBirthdayend() {
		return birthdayend;
	}
	public void setBirthdayend(String birthdayend) {
		this.birthdayend = birthdayend;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
