package com.zw.zwshop.controller;

/**
 * 
 * @ClassName:  PageController   
 * @Description: 页面跳转控制
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:28:19
 */
//@Controller
public class PageController {
	
	//@RequestMapping("admin")
	public String toAdmin(){
		return "admin/index.html";
	}

}
