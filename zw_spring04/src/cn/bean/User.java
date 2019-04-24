package cn.bean;
/**
 * 
 * 类描述：用户登录类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class User {
	
	/**
	 * 
	 * 方法描述:用户登录
	 */
	public void login(){
		System.out.println("login...");
	}
	
	/**
	 * 
	 * 方法描述: 
	 * @param username
	 * @return
	 */
	public String login(String username){
		/*try {
			// 用于测试异常通知
			int a = 1 / 0;
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		System.out.println("String+login..."+username);
		return username;
	}

}
