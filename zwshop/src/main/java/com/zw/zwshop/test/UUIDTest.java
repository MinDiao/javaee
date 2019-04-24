package com.zw.zwshop.test;

import java.util.UUID;

import org.junit.Test;

public class UUIDTest {

	/**
	 * 
	 * @Description:随机生成UUID
	 * @author: LiuJinrong
	 * @date:   2019年1月5日 下午2:17:21
	 */
	@Test
	public void test() {
		// UUID
		String uuid = UUID.randomUUID().toString();
		// 输出
		System.out.println(uuid);
	}

}
