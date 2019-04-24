package com.zw.pojo;

/**
 * 
 * 类描述：用户实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月19日
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
	// 用户密码
	private String pwd;
	// 用户性别
	private String sex;
	// 用户爱好
	private String love;
	// 用户生日
	private String birthday;
	// 用户地址
	private String address;
	// 用户邮箱
	private String email;
	// 创建时间
	private String createDate;
	// 修改时间
	private String updateDate;
	
	public User() {
		
	}

	/**
	 * 用户首页查询
	 * @param username
	 * @param sex
	 * @param birthday
	 */
	public User(String username, String sex, String birthday) {
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
	}

	public User(String username, String pwd, String sex, String love, String birthday, String address, String email,
			String createDate, String updateDate) {
		this.username = username;
		this.pwd = pwd;
		this.sex = sex;
		this.love = love;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.createDate = createDate;
		this.updateDate = updateDate;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", sex=" + sex + ", love=" + love
				+ ", birthday=" + birthday + ", address=" + address + ", email=" + email + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
}
