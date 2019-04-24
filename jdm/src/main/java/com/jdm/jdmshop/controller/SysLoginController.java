package com.jdm.jdmshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdm.jdmshop.pojo.SysUser;
import com.jdm.jdmshop.service.SysUserService;
import com.jdm.jdmshop.utils.R;

/**
 * 
 * @ClassName:  SysUserController   
 * @Description: 管理员控制层 
 * @author: LiuJinrong
 * @date:   2019年1月25日 上午10:35:44
 */
@Controller
@RequestMapping("sys_login")
public class SysLoginController {
	
	/**
	 * 注入Service
	 */
	@Autowired
	private SysUserService sysUserService;
	
	
	/**
	 * 
	 * @Description: 管理员登录
	 * @author: LiuJinrong
	 * @date:   2019年1月25日 下午8:03:03    
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public R login(SysUser sysUser){
		
		// 创建管理员对象
		SysUser loginUser = null;
		
		try {
			// 调用管理员服务层方法
			loginUser = sysUserService.login(sysUser);
			
		} catch (Exception e) {
			// 抛出异常
			e.printStackTrace();
			// 向页面响应错误
			return R.error("服务器发生未知异常,请联系管理员");
		}
		
		// 判断是否存在此管理员, 来判断登录是否成功
		if (loginUser != null) {
			// 向页面响应登录成功信息
			return R.ok().put("loginUser", loginUser);
			
		} else {
			// 数据库无此管理员用户名, 则登录失败
			return R.error("账户或密码错误");
		}
		
	}
	
	
	
	/**
	 * 
	 * @Description: 是否重名
	 * @author: LiuJinrong
	 * @date:   2019年1月26日 下午7:10:47    
	 * @param username
	 * @return
	 */
//	public R nameEqual(String username){
//		
//	}
	
	
	
	/**
	 * 
	 * @Description: 注册管理员
	 * @author: LiuJinrong
	 * @date:   2019年1月26日 下午7:10:50    
	 * @param sysUser
	 * @return
	 */
//	public R register(SysUser sysUser){
//		
//	}
	

}














