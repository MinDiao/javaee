package com.jdm.jdmshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdm.jdmshop.pojo.Member;
import com.jdm.jdmshop.service.MemberService;
import com.jdm.jdmshop.utils.R;

/**
 * 
 * @ClassName:  MemberController   
 * @Description: 会员信息控制层 
 * @author: LiuJinrong
 * @date:   2019年1月25日 下午3:36:45
 */
@Controller
@RequestMapping("member")
public class MemberController {
	
	/**
	 * 注入service
	 */
	@Autowired
	private MemberService memberService;
	
	
	
	/**
	 * 
	 * @Description: 会员登录
	 * @author: LiuJinrong
	 * @date:   2019年1月25日 下午3:44:19    
	 * @param member
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public R login(Member member){
		
		// 创建会员对象
		Member loginMember = null;
	
		try {
			// 调用业务逻辑层会员登录方法
			loginMember = memberService.login(member);
			
		} catch (Exception e) {
			// 抛出异常
			e.printStackTrace();
			// 向页面显示错误信息
			return R.error("服务器发生未知异常,请联系管理员");
		}
		
		// 根据影响行数判断登录是否成功
		if (loginMember != null) {
			// 数据库存在,登录成功
			return R.ok().put("loginMember", loginMember);
			
		} else {
			// 数据库中不存在,登录失败
			return R.error("账户或密码错误");
		}
		
	}

}














