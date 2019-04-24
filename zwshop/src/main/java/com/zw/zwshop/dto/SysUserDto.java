package com.zw.zwshop.dto;
/**
 * 
 * @ClassName:  SysUserDto   
 * @Description: 管理员查询条件 
 * @author: LiuJinrong
 * @date:   2019年1月7日 上午10:26:21
 */
public class SysUserDto {
	
	/**
	 * 当前页
	 */
	private int page = 1;
	/**
	 * 页容量
	 */
	private int limit = 10;
	/**
	 * 用户名
	 */
	private String username;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
