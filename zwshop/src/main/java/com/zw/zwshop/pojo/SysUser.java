package com.zw.zwshop.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  SysUser
 * @Description: 管理员实体类
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:19:11
 */

@Table(name="sys_user")
public class SysUser {

	// 主键ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	// 用户名
	private String username;
	// 密码, 加密处理（md5）
	private String password;
	// 创建时间
	private String createTime;
	// 备注信息
	private String remarks;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
