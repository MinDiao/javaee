package cn.pojo;
/**
 * 
 * 类描述：用户实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class User {
	// 用户名
	private String username;
	// 用户密码
	private String password;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
