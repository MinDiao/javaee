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
 * @ClassName:  SysLoginController   
 * @Description:TODO 管理员登录模块
 * @author: lilong
 * @date:   2019年1月7日 下午2:48:27       
 */  
@Controller
@RequestMapping("sysLogin")
public class SysLoginController {

	@Autowired
	private SysUserService sysUserService;
	
	/**     
	 * @Description:TODO 管理员登录
	 * @author: lilong
	 * @date:   2019年1月7日 下午2:55:10    
	 * @param sysUser
	 * @return      
	 */  
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public R login(SysUser sysUser){
		SysUser loginUser = null;
		try {
			loginUser = sysUserService.login(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("发生未知异常，请联系管理员！");
		}
		if(loginUser!=null){
			return R.ok().put("loginUser", loginUser);
		}else {
			return R.error("账户或者密码错误");
		}
		
	}
	
}
