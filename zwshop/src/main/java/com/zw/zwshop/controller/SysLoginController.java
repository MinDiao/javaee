package com.zw.zwshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zw.zwshop.pojo.SysUser;
import com.zw.zwshop.service.SysUserService;
import com.zw.zwshop.utils.R;

/**
 * 
 * @ClassName:  SysLoginController   
 * @Description:  登录
 * @author: LiuJinrong
 * @date:   2019年1月7日 下午2:49:08
 */

@Controller
@RequestMapping("sysLogin")
public class SysLoginController {

	
	/**
	 * 注入SysUserService
	 */
	@Autowired
	private SysUserService sysUserService;
	
	
	
	/**
	 * 
	 * @Description: 管理员登录模块
	 * @author: LiuJinrong
	 * @date:   2019年1月7日 下午2:55:31    
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public R login(SysUser sysUser){
		
		// 声明对象
		
		SysUser loginUser = null;
		
		try {
			// 调用登录/查询功能
			loginUser = sysUserService.login(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			return R.error("发生未知异常,请联系管理员");
		}
		
		if (loginUser != null) {
			return R.ok().put("loginUser", loginUser);
		} else {
			return R.error("账户或密码错误");
		}
		
	}
}















