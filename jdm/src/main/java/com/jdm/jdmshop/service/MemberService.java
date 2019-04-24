package com.jdm.jdmshop.service;

import com.jdm.jdmshop.pojo.Member;

/**
 * 
 * @ClassName:  MemberService   
 * @Description: 会员信息业务逻辑层接口 
 * @author: LiuJinrong
 * @date:   2019年1月25日 下午3:30:49
 */
public interface MemberService {

	
	/**
	 * 
	 * @Description: 会员登录
	 * @author: LiuJinrong
	 * @date:   2019年1月25日 下午4:09:27    
	 * @param member
	 * @return
	 */
	Member login(Member member);

}
