package com.jdm.jdmshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.jdmshop.mapper.MemberMapper;
import com.jdm.jdmshop.pojo.Member;
import com.jdm.jdmshop.service.MemberService;

/**
 * 
 * @ClassName:  MemberServiceImpl   
 * @Description: 会员信息业务逻辑层实现类
 * @author: LiuJinrong
 * @date:   2019年1月25日 下午3:33:12
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	/**
	 * 注入mapper
	 */
	@Autowired
	private MemberMapper memberMapper;

	
	
	/**
	 * 会员登录
	 */
	@Override
	public Member login(Member member) {
		
		return memberMapper.selectOne(member);
	}

}
















